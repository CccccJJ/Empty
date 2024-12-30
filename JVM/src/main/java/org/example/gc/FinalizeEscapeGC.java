package org.example.gc;

public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        // Finalize 方法优先级很低，暂停 0.5 秒等待
        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead :(");
        }

        // 下面这段代码与上面代码完全相同，但这次自救却失败了
        SAVE_HOOK = null;
        System.gc();

        // Finalize 方法优先级很低，暂停 0.5 秒等待
        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am dead :(");
        }
    }
}
