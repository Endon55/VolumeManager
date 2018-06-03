

/*
    This project is so I can mute, unmute, and change volume of programs via Hotkey.

    Uses
    https://github.com/kristian/system-hook


    Core audio api
 */


public class VolumeManager
{
    public static void main(String[] args)
    {
        String program = "TslGame.exe";
        //System.out.println("Status: " + status);
        if(args.length > 0)
        {
            program = args[0];
        }
        GlobalHotkeys hk = new GlobalHotkeys(program, .05f);

        hk.start();
        try
        {
            while (hk.getRunning())
            {
                Thread.sleep(128);
            }
        } catch (InterruptedException e)
        {}
        finally{
            hk.shutdown();
        }

        //while(true){}
    }
}

