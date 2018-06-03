
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalHotkeys
{
    private String program;
    private float deltaProgram;

    private static boolean running = true;
    private GlobalKeyboardHook keyHook = new GlobalKeyboardHook();


    VolumeManagerDLL jnaLib;

    public static boolean getRunning(){ return running; }

    public static void setRunning(boolean running){ GlobalHotkeys.running = running; }

    public GlobalHotkeys(String program, float deltaProgram)
    {
        this.program = program;
        this.deltaProgram = deltaProgram;

        //System.setProperty("java.library.path", "lib");
        System.setProperty("jna.library.path", "");
        //System.loadLibrary("VolumeManagerDLL");
        jnaLib = VolumeManagerDLL.INSTANCE;
    }

    public void start()
    {
        keyHook.addKeyListener(new GlobalKeyAdapter()
        {
            @Override
            public void keyPressed(GlobalKeyEvent event)
            {
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_S && event.isShiftPressed() && event.isControlPressed())
                {
                    jnaLib._Z12ChangeVolumefbPKc(deltaProgram, true, program);
                }
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_A && event.isShiftPressed() && event.isControlPressed())
                {
                    jnaLib._Z12ChangeVolumefbPKc(deltaProgram, false, program);
                }
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_P && event.isShiftPressed() && event.isControlPressed())
                {
                    System.out.println("Quitting!");
                    setRunning(false);
                }
            }
        });

    }
    public void shutdown(){ keyHook.shutdownHook(); }
}