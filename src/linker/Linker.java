/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linker;
import java.net.URI;
import java.awt.Desktop;

/**
 *
 * @author natrixanorax
 */
public class Linker {
    
    private static String URI;
    
    public Linker(String URI) {
        this.URI = URI;
    }


   public static void run() {

        if( !java.awt.Desktop.isDesktopSupported() ) {

            System.err.println( "Desktop is not supported (fatal)" );
            System.exit( 1 );
        }

       /* if ( args.length == 0 ) {

            System.out.println( "Usage: OpenURI [URI [URI ... ]]" );
            System.exit( 0 );
        } */

        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

        if( !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {

            System.err.println( "Desktop doesn't support the browse action (fatal)" );
            System.exit( 1 );
        }

       // for ( String arg : args ) {

            try {

                java.net.URI uri = new java.net.URI( URI );
                desktop.browse( uri );
            }
            catch ( Exception e ) {

                System.err.println( e.getMessage() );
           // }
        }
    }
}
