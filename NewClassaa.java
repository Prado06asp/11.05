import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutFrame extends Jframe implements ActionListener
{
    private JButton[] buttons; // array de botões para ocultar partes
    private static final String[] names = {"Hide North","Hide South","Hide East","Hide West","Hide Center"};
    private BorderLayout layout;//objeto border layout
    
    //configura GUI e tratamento de evento
    public BorderLayoutFrame()
    {
        super("BorderLayout Demo");
        
        layout = new BorderLayout (5 , 5);//espaços de 5 pixels
        setLayout(layout);//configura o layout de frame
        buttons = new JButton[names.length];//configura o tamanho do array
        // criar JButtons e registra listeners para eles
        for ( int count = 0 ; count < names.length; count++)
        {
            buttons [count]= new JButton ( names[count]);
            buttons [count].addActionListener(this);
        }//for final
        
        add( buttons[0],BorderLayout.NORTH);//adiciona botão para norte
        add( buttons[1],BorderLayout.SOUTH);//adiciona botão para sul
        add( buttons[2],BorderLayout.EAST);//adiciona botão para leste
        add( buttons[3],BorderLayout.WEST);//adiciona botão para oeste
        add( buttons[4],BorderLayout.CENTER);//adiciona botão para centro
    }//fim do construtor BorderLayoutFrame   
    //trata os eventos de botão
    public void actionPerformed(ActionEvent event)
    {
        //verifica a origem de evento e o painel de conteúdo de layout correspondentemente
        for(JButton button : buttons)
        {
            if (event.getSource()== button)
                button.setVisible(false);//oculta o botão clicado
            else
                button.setVisible(true);//mostra outros botões
        }//for final
        layout.layoutContainer(getContentPane());//faz o layout do painel de conteúdo
    }
}