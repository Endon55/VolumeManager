import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalHotkeys
{
    private static boolean running = true;
    private GlobalKeyboardHook keyHook = new GlobalKeyboardHook();

    VolumeManagerDLL jnaLib = VolumeManagerDLL.INSTANCE;
    boolean status = jnaLib._Z12ChangeVolumefbPKc(.05f, true, "TslGame.exe");


    public static boolean getRunning(){ return running; }

    public static void setRunning(boolean running){ GlobalHotkeys.running = running; }

    public void start()
    {
        keyHook.addKeyListener(new GlobalKeyAdapter()
        {
            @Override
            public void keyPressed(GlobalKeyEvent event)
            {
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_F5 && event.isShiftPressed())
                {
                    jnaLib._Z12ChangeVolumefbPKc(.05f, true, "TslGame.exe");
                }
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_F4 && event.isShiftPressed())
                {
                    jnaLib._Z12ChangeVolumefbPKc(.05f, false, "TslGame.exe");
                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_A && event.isShiftPressed())
                {

                    System.out.println("Quitting!");
                    setRunning(false);
                }
                //if(event.)
            }
        });

    }
    public void shutdown(){ keyHook.shutdownHook(); }
}