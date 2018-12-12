import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

/**
 * @Author: Jay
 * @Date: Created in 20:22 2018/12/3
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("begin");
        Main m = new Main();
        m.engine();
        System.out.println("----");
        m.startBuyerAgent("192.168.88.1","8800","rma");
        System.out.println("end");
    }

    /**
     * 启动一个agent容器
     */
    public void engine() {
        Runtime rt = Runtime.instance();
        rt.setCloseVM(true);
        Profile pMain = new ProfileImpl(null, 8800, null);

        AgentContainer mc = rt.createMainContainer(pMain);
        // set now the default Profile to start a container
        ProfileImpl pContainer = new ProfileImpl(null, 8800, null);
        System.out.println(("运行Agent容器 ..." + pContainer));
        AgentController rma = null;
        try {
            rma = mc.createNewAgent("rma", "hello.HelloWorldAgent", null);
            rma.start();
            AgentController buyer = mc.createNewAgent("buyer", "bookTrading.BookBuyerAgent", null);
            buyer.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
        System.out.println("我已经启动了一个小Agent");
    }

    /**
     * @param host 交易环境主容器
     * @param port 交易环境主容器端口
     * @param name Agent名称
     * @return 外部调用agent的接口
     */
    public AgentController startBuyerAgent(String host, String port, String name) {
        System.out.println("开始了");
//        获取运行实例
        Runtime rt = Runtime.instance();

//      创建容器用于驻留买方Agent
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, host);
        p.setParameter(Profile.MAIN_PORT, port);
        ContainerController cc = rt.createAgentContainer(p);
        if (cc != null) {
            try {
                System.out.println("再启动一次");
                AgentController ac = cc.createNewAgent(name, "hello.HelloWorldAgent", null);
                ac.start();
                return ac;
            } catch (StaleProxyException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束了");
        return null;
    }
}
