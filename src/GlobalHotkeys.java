import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalHotkeys
{



    private static boolean running = true;
    private GlobalKeyboardHook keyHook = new GlobalKeyboardHook();



    public static boolean getRunning(){ return running; }

    public static void setRunning(boolean running){ GlobalHotkeys.running = running; }

    public void start()
    {
        keyHook.addKeyListener(new GlobalKeyAdapter()
        {
            @Override
            public void keyPressed(GlobalKeyEvent event)
            {
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