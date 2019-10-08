import com.lvgo.unname.SyncRunList;
import com.lvgo.unname.ThreadPoolFactory;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String[] args) {
        ExecutorService threadPool = ThreadPoolFactory.newThreadPool();


        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            strings.add("��" + i + "��");
        }
        new SyncRunList<String>(strings) {
            /**
             * ��Ԫ������ִ��
             *
             * @param task Ԫ��
             */
            @Override
            protected void taskRun(String task) {
                System.out.println("task = " + task);
            }
        }.execute(threadPool, 5);
        System.out.println("strings = " + strings);
    }
}
