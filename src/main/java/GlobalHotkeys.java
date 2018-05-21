package src.main.java;

import src.main.resources.VolumeManagerDLL;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalHotkeys
{

    private String program;
    private float deltaProgram;

    private static boolean running = true;
    private GlobalKeyboardHook keyHook = new GlobalKeyboardHook();

    VolumeManagerDLL jnaLib = VolumeManagerDLL.INSTANCE;


    public static boolean getRunning(){ return running; }

    public static void setRunning(boolean running){ GlobalHotkeys.running = running; }

    public GlobalHotkeys(String program, float deltaProgram)
    {
        this.program = program;
        this.deltaProgram = deltaProgram;
    }

    public void start()
    {
        keyHook.addKeyListener(new GlobalKeyAdapter()
        {
            @Override
            public void keyPressed(GlobalKeyEvent event)
            {
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_F5 && event.isShiftPressed())
                {
                    jnaLib._Z12ChangeVolumefbPKc(deltaProgram, true, program);
                }
                if(event.getVirtualKeyCode() == GlobalKeyEvent.VK_F4 && event.isShiftPressed())
                {
                    jnaLib._Z12ChangeVolumefbPKc(deltaProgram, false, program);
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