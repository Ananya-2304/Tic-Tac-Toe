import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener{
    JButton[] buttons = new JButton[9];
    JLabel textfield = new JLabel();
    JPanel title_panel = new JPanel();
    JPanel button_Panel = new JPanel();
    boolean player1;
    TicTacToe(String name){
        ImageIcon image = new ImageIcon("D:/JavaGUI/566294.png");
        Font myFont = new Font("Comic Sans MS",Font.BOLD,30);

        textfield.setText("Tic-Tac-Toe");
        textfield.setForeground(new Color(255,255,255));
        textfield.setBackground(new Color(0,0,0));
        textfield.setFont(myFont);
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setTitle(name);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(image.getImage());
        this.setSize(300,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,300,100);
        
        button_Panel.setBounds(300,100,200,300);
        button_Panel.setLayout(new GridLayout(3,3,2,2));

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_Panel.add(buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].setFont(myFont);
            buttons[i].setBackground(new Color(0,0,0));
            buttons[i].setFocusable(false);
            buttons[i].setEnabled(false);
        }
        
        title_panel.add(textfield);
        this.add(title_panel,BorderLayout.NORTH);
        this.add(button_Panel);
       
        firstTurn();
    }
    public static void main(String[] args){
        new TicTacToe("TicTacToe");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int i;
        for(i=0;i<9;i++){
            if(e.getSource() ==buttons[i]){
                if(player1){
                    if(buttons[i].getText()==""){
                        buttons[i].setText("X");
                        buttons[i].setForeground(new Color(255,0,0));
                        player1=false;
                        textfield.setText("Player O's Turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setText("O");
                        buttons[i].setForeground(new Color(0,0,255));
                        player1=true;
                        textfield.setText("Player X's Turn");
                        check();
                    }
                    }
                }    
        }
    }
    public void firstTurn(){
        try {
            Thread.sleep(3000);
            Random random = new Random();
            if(random.nextInt(2)==0){
               player1=true;
               textfield.setText("Player X's Turn");
            }
            else{
               player1=false;
               textfield.setText("Player O's Turn");
            }
            for(int i=0;i<9;i++)
               buttons[i].setEnabled(true);
           
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void check(){
        if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")&&(buttons[2].getText()=="X"))
            wins(0,1,2);
        else if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[5].getText()=="X"))
            wins(3,4,5);
        else if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")&&(buttons[8].getText()=="X"))
            wins(6,7,8);
        else if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")&&(buttons[6].getText()=="X"))
            wins(0,3,6);
        else if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[7].getText()=="X"))
            wins(1,4,7);
        else if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")&&(buttons[8].getText()=="X"))
            wins(2,5,8);
        else if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[8].getText()=="X"))
            wins(0,4,8);
        else if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")&&(buttons[6].getText()=="X"))
            wins(2,4,6);
        else if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")&&(buttons[2].getText()=="O"))
            wins(0,1,2);
        else if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[5].getText()=="O"))
            wins(3,4,5);
        else if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")&&(buttons[8].getText()=="O"))
            wins(6,7,8);
        else if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")&&(buttons[6].getText()=="O"))
            wins(0,3,6);
        else if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[7].getText()=="O"))
            wins(1,4,7);
        else if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")&&(buttons[8].getText()=="O"))
            wins(2,5,8);
        else if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[8].getText()=="O"))
            wins(0,4,8);
        else if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")&&(buttons[6].getText()=="O"))
            wins(2,4,6);
        else if(checkDraw()){
            textfield.setForeground(new Color(0,0,255));
            textfield.setText("Its a Draw!");
            for(int i=0;i<9;i++)
              buttons[i].setEnabled(false);
        }
    }
    public Boolean checkDraw(){
        for(int i =0;i<9;i++){
            if(buttons[i].getText()=="")
               return false;
        }
        return true;
    }
    public void wins(int a,int b,int c){
         
         buttons[a].setForeground(new Color(0,255,0));
         buttons[b].setForeground(new Color(0,255,0));
         buttons[c].setForeground(new Color(0,255,0));
         
         if(buttons[a].getText()=="X"){
            textfield.setText("Player X Wins");
            textfield.setForeground(new Color(0,255,0));
         }
         else{
            textfield.setText("Player O Wins");
            textfield.setForeground(new Color(0,255,0));
         }
         for(int i=0;i<9;i++){
            if(i==a ||i==b ||i==c)
               continue;
            buttons[i].setEnabled(false);
         }
         
    }
}
