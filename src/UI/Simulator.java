/*
 * DAA Algorithm Simulator
 * Design and Analysis of Algorithms IT240 Assignment - 2016
 * 
 * Student Name : Perera P.D.S   
 * IT Number    : IT14031380
*/
package UI;

import java.awt.Color;
import javax.swing.JLabel;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static java.lang.Thread.sleep;

public class Simulator extends javax.swing.JFrame {
    
    int xMousePos;
    int yMousePos;
    JLabel[] lblArray;
    static int[] dataArry;
    JButton btnArr[];
    public int index ;
    static int aniTime;
    static int movingTime;
    Random rand;
    int randNum;
    
    public Simulator() 
    {
        initComponents();
        rand = new Random();
               
        dataArry = new int[]{100,120,70,160,200,50,140,230,170,160,150,75,180,95,45};     
        lblArray = new JLabel[] {lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15};
        
        aniTime = 10;
        movingTime = 1000;
        generateRandomDataList();
        displayArr();
        
        lblHelp.setText("");
        lblHelpResult.setText("");
        lblSwapResult.setText("");
    }
    
    public final void displayArr()
    {
        // Setting numbers
        lbl1.setText(dataArry[0]+"");
        lbl2.setText(dataArry[1]+"");
        lbl3.setText(dataArry[2]+"");
        lbl4.setText(dataArry[3]+"");
        lbl5.setText(dataArry[4]+"");
        
        lbl6.setText(dataArry[5]+"");
        lbl7.setText(dataArry[6]+"");
        lbl8.setText(dataArry[7]+"");
        lbl9.setText(dataArry[8]+"");
        lbl10.setText(dataArry[9]+"");
        
        lbl11.setText(dataArry[10]+"");
        lbl12.setText(dataArry[11]+"");
        lbl13.setText(dataArry[12]+"");
        lbl14.setText(dataArry[13]+"");
        lbl15.setText(dataArry[14]+"");
        
        // Setting Sizes
        lbl1.setSize(30, dataArry[0]);
        lbl2.setSize(30, dataArry[1]);
        lbl3.setSize(30, dataArry[2]);
        lbl4.setSize(30, dataArry[3]);
        lbl5.setSize(30, dataArry[4]);
        
        lbl6.setSize(30, dataArry[5]);
        lbl7.setSize(30, dataArry[6]);
        lbl8.setSize(30, dataArry[7]);
        lbl9.setSize(30, dataArry[8]);
        lbl10.setSize(30, dataArry[9]);
        
        lbl11.setSize(30, dataArry[10]);
        lbl12.setSize(30, dataArry[11]);
        lbl13.setSize(30, dataArry[12]);
        lbl14.setSize(30, dataArry[13]);
        lbl15.setSize(30, dataArry[14]);
         
        // Setting locations
        lbl1.setLocation(lbl1.getLocation().x, 250-dataArry[0]);
        lbl2.setLocation(lbl2.getLocation().x, 250-dataArry[1]);
        lbl3.setLocation(lbl3.getLocation().x, 250-dataArry[2]);
        lbl4.setLocation(lbl4.getLocation().x, 250-dataArry[3]);
        lbl5.setLocation(lbl5.getLocation().x, 250-dataArry[4]);
        
        lbl6.setLocation(lbl6.getLocation().x, 250-dataArry[5]);
        lbl7.setLocation(lbl7.getLocation().x, 250-dataArry[6]);
        lbl8.setLocation(lbl8.getLocation().x, 250-dataArry[7]);
        lbl9.setLocation(lbl9.getLocation().x, 250-dataArry[8]);
        lbl10.setLocation(lbl10.getLocation().x, 250-dataArry[9]);
        
        lbl11.setLocation(lbl11.getLocation().x, 250-dataArry[10]);
        lbl12.setLocation(lbl12.getLocation().x, 250-dataArry[11]);
        lbl13.setLocation(lbl13.getLocation().x, 250-dataArry[12]);
        lbl14.setLocation(lbl14.getLocation().x, 250-dataArry[13]);
        lbl15.setLocation(lbl15.getLocation().x, 250-dataArry[14]);
    }
    
    public void colourRest() {
        for (JLabel lblArray1 : lblArray) {
            lblArray1.setBackground(new Color(241, 196, 15));
        }
    }
    
    private void setSpeed() {
        jsSpeed.setValue(jsSpeed.getValue());
        int valSpeed = (jsSpeed.getValue() + 1) / 10;
        aniTime = 10;
        aniTime = (aniTime - valSpeed) + 1;
        movingTime = 1000;
        movingTime = (movingTime - valSpeed * 100) + 1;
    }
    
    private void generateRandomDataList()
    {
        txtValues.setText("");
        for(int i = 0; i< dataArry.length ; i++)
        {
            int  n = rand.nextInt(220) + 30;
            dataArry[i] = n;
            if(i==0)
            {
                txtValues.setText(n+"");
            }
            else
            {
                 txtValues.setText(txtValues.getText() + "," + n);
            }
           
        }
        
    }
    
    private void disableObjects()
    {
       
        btnInsertionSort.setEnabled(false);
        btnSelectionSort.setEnabled(false);
        btnBubbleSort.setEnabled(false);
        btnRand.setEnabled(false);
        
        txtValues.setEnabled(false);
        jrbAsc.setEnabled(false);
        jrbDesc.setEnabled(false);
    }
    
    private void enableObjects()
    {
         btnInsertionSort.setEnabled(true);
        btnSelectionSort.setEnabled(true);
        btnBubbleSort.setEnabled(true);
        btnRand.setEnabled(true);
         
        txtValues.setEnabled(true);
        jrbAsc.setEnabled(true);
        jrbDesc.setEnabled(true);
    }
       
    private Boolean setArray()
    {
         StringTokenizer st = new StringTokenizer(txtValues.getText(),",");
         int i = 0; 
         if(st.countTokens() == 15)
         {
             while (st.hasMoreTokens()) 
            {
            dataArry[i] = Integer.parseInt(st.nextToken());
            i++;
            }
             
            displayArr();
            return true;
         }
         else
         {
             JOptionPane.showMessageDialog(null,"Enter 15 Numbers!");
             return false;
         }
         
    }
            
    public void BubbleSort() {
        setArray();
        setBSSource();
        lblKeyA1.setBackground(new Color(26, 188, 156));
        lblKeyA2.setBackground(new Color(52, 73, 94));
        lblKeyA3.setVisible(false);
        lblKeyIndexA3.setVisible(false);
        lblProgress.setText("Sorting...");
        lblProgress.setBackground(new Color(230, 126, 34));
        new Thread(()
                -> {
            disableObjects();
            for (int i = 0; i < lblArray.length - 1; i++) {
               
                for (int j = 0; j < lblArray.length - 1 - i; j++) {
                    int J = Integer.parseInt(lblArray[j].getText());    
                    int Jplus1 = Integer.parseInt(lblArray[j + 1].getText());  

                    lblKeyIndexA1.setText(" j = " + lblArray[j].getText());
                    lblKeyIndexA2.setText(" j-1 = " + lblArray[j + 1].getText());

                    colourRest();
                    lblArray[j].setBackground(new Color(26, 188, 156));     
                    lblArray[j + 1].setBackground(new Color(52, 73, 94)); 

                    if (jrbAsc.isSelected()) {
                        if (J > Jplus1) 
                        {
                            lblHelp.setText("Is " + J + " >  Than " + Jplus1);
                            lblHelpResult.setText("YES");
                            lblHelpResult.setForeground(new Color(46, 204, 113));
                            lblSwapResult.setText("SWAP " + J + " AND " + Jplus1);
                            try {sleep(movingTime);} catch (Exception e) {}   

                            int d = lblArray[j + 1].getLocation().x - lblArray[j].getLocation().x;

                            for (int t = 0; t < d; t++) {
                                lblArray[j].setLocation(lblArray[j].getLocation().x + 1, lblArray[j].getLocation().y);
                                lblArray[j + 1].setLocation(lblArray[j + 1].getLocation().x - 1, lblArray[j + 1].getLocation().y);
                                try {sleep(aniTime);} catch (Exception e) {}
                            }

                            JLabel lblTemp = lblArray[j];
                            lblArray[j] = lblArray[j + 1];
                            lblArray[j + 1] = lblTemp;

                            lblKeyIndexA1.setText(" j = " + lblArray[j].getText());
                            lblKeyIndexA2.setText(" j-1 = " + lblArray[j + 1].getText());

                        }

                        lblHelpResult.setText("NO");
                        lblHelpResult.setForeground(new Color(231, 76, 60));
                        lblSwapResult.setText("DON'T Swap " + J + " AND " + Jplus1);
                        try {sleep(movingTime*2);} catch (Exception e) {}   
                        lblSwapResult.setText("");
                        
                    } else if (jrbDesc.isSelected()) {
                        if (J < Jplus1) 
                        {
                            lblHelp.setText("Is " + J + " <  Than " + Jplus1);
                            lblHelpResult.setText("YES");
                            lblHelpResult.setForeground(new Color(46, 204, 113));
                            lblSwapResult.setText("SWAP " + J + " AND " + Jplus1);
                            try {sleep(movingTime);} catch (Exception e) {}   

                            int d = lblArray[j + 1].getLocation().x - lblArray[j].getLocation().x;

                            for (int t = 0; t < d; t++) {
                                lblArray[j].setLocation(lblArray[j].getLocation().x + 1, lblArray[j].getLocation().y);
                                lblArray[j + 1].setLocation(lblArray[j + 1].getLocation().x - 1, lblArray[j + 1].getLocation().y);
                                try {sleep(aniTime);} catch (Exception e) {}
                            }

                            JLabel lblTemp = lblArray[j];
                            lblArray[j] = lblArray[j + 1];
                            lblArray[j + 1] = lblTemp;

                            lblKeyIndexA1.setText(" j = " + lblArray[j].getText());
                            lblKeyIndexA2.setText(" j-1 = " + lblArray[j + 1].getText());
                        }

                        lblHelpResult.setText("NO");
                        lblHelpResult.setForeground(new Color(231, 76, 60));
                        lblSwapResult.setText("DON'T Swap " + J + " AND " + Jplus1);
                        try {sleep(movingTime*2);} catch (Exception e) {}   
                        lblSwapResult.setText("");
                    }
                }
                lblSwapResult.setText("");
                colourRest();
            }
            enableObjects();
            lblProgress.setText("Sorting Complete!");
            lblProgress.setBackground(new Color(39, 174, 96));
            lblHelp.setText("");
            lblHelpResult.setText("");
            lblSwapResult.setText("");
        }).start();
    }

    
    public void SelectionSort() {
         setSSSource();
        lblKeyA1.setBackground(new Color(26, 188, 156));
        lblKeyA2.setBackground(new Color(52, 73, 94));
        lblKeyA3.setBackground(new Color(155, 89, 182));
        lblProgress.setText("Sorting...");
        lblProgress.setBackground(new Color(230, 126, 34));
        new Thread(()
                -> {
        disableObjects();
       
            for (int i = 0; i < lblArray.length - 1; i++) {
                lblKeyIndexA1.setText(" i = " + lblArray[i].getText());
                index = i;
                int pIndex = Integer.parseInt(lblArray[index].getText());
                lblKeyIndexA3.setText(" index = " + pIndex);

                for (int j = i + 1; j < lblArray.length; j++) {
                    int pJ = Integer.parseInt(lblArray[j].getText());
                    lblKeyIndexA2.setText(" j = " + pJ);

                    if (jrbAsc.isSelected()) {
                        if (pJ < pIndex) {index = j;}
                    } else if (jrbDesc.isSelected()) {
                        if (pJ > pIndex) {index = j;}
                    }

                    colourRest();

                    lblArray[i].setBackground(new Color(26, 188, 156));
                    lblArray[j].setBackground(new Color(52, 73, 94));
                    lblArray[index].setBackground(new Color(155, 89, 182));
                    try {sleep(movingTime);} catch (Exception e) {}

                    pIndex = Integer.parseInt(lblArray[index].getText());
                    lblKeyIndexA3.setText(" index = " + pIndex);
                }

                int pI = Integer.parseInt(lblArray[i].getText());
                lblKeyIndexA1.setText(" i =  " + pI);

                if (jrbAsc.isSelected()) {

                    if (pI > pIndex) {

                        lblHelp.setText("Is " + pI + " >  Than " + pIndex);
                        lblHelpResult.setText("YES");
                        lblHelpResult.setForeground(new Color(46, 204, 113));
                        lblSwapResult.setText("SWAP " + pI + " AND " + pIndex);
                        try {sleep(movingTime);} catch (Exception e) {}

                        int d = lblArray[index].getLocation().x - lblArray[i].getLocation().x;

                        for (int t = 0; t < d; t++) {
                            lblArray[i].setLocation(lblArray[i].getLocation().x + 1, lblArray[i].getLocation().y);
                            lblArray[index].setLocation(lblArray[index].getLocation().x - 1, lblArray[index].getLocation().y);
                            try {sleep(aniTime);} catch (Exception e) {}
                        }

                        JLabel xsmallerNumber = lblArray[index];
                        lblArray[index] = lblArray[i];
                        lblArray[i] = xsmallerNumber;
                        try {sleep(movingTime);} catch (Exception e) {}
                    }
                    lblHelp.setText("Is " + pI + " >  Than " + pIndex);
                    lblHelpResult.setText("NO");
                    lblHelpResult.setForeground(new Color(231, 76, 60));
                    lblSwapResult.setText("DON'T Swap " + pI + " AND " + pIndex);
                    try {sleep(movingTime*2);} catch (Exception e) {} 
                    lblHelp.setText("");
                    lblHelpResult.setText("");
                    lblSwapResult.setText("");
                } else if (jrbDesc.isSelected()) {
                    if (pI < pIndex) {

                        lblHelp.setText("Is " + pI + " <  Than " + pIndex);
                        lblHelpResult.setText("YES");
                        lblHelpResult.setForeground(new Color(46, 204, 113));
                        lblSwapResult.setText("SWAP " + pI + " AND " + pIndex);
                        try {sleep(movingTime);} catch (Exception e) {}   

                        int d = lblArray[index].getLocation().x - lblArray[i].getLocation().x;

                        for (int t = 0; t < d; t++) {
                            lblArray[i].setLocation(lblArray[i].getLocation().x + 1, lblArray[i].getLocation().y);
                            lblArray[index].setLocation(lblArray[index].getLocation().x - 1, lblArray[index].getLocation().y);
                            try {sleep(aniTime);} catch (Exception e) {}
                        }

                        JLabel xsmallerNumber = lblArray[index];
                        lblArray[index] = lblArray[i];
                        lblArray[i] = xsmallerNumber;
                        try {sleep(movingTime);} catch (Exception e) {}}

                    lblHelp.setText("Is " + pI + " <  Than " + pIndex);
                    lblHelpResult.setText("NO");
                    lblHelpResult.setForeground(new Color(231, 76, 60));
                    lblSwapResult.setText("DON'T Swap " + pI + " AND " + pIndex);
                    try {sleep(movingTime*2);} catch (Exception e) {}   
                    lblHelp.setText("");
                    lblHelpResult.setText("");
                    lblSwapResult.setText("");
                }
            }
            colourRest();
            enableObjects();
            lblProgress.setText("Sorting Complete!");
            lblProgress.setBackground(new Color(39, 174, 96));
            lblHelp.setText("");
            lblHelpResult.setText("");
            lblSwapResult.setText("");
        }).start();
    }

    public void InsertionSort() {
        setArray();
        disableObjects();
        setISSource();
        lblProgress.setText("Sorting...");
        lblProgress.setBackground(new Color(230, 126, 34));
        lblKeyA1.setBackground(new Color(26, 188, 156));
        lblKeyA2.setBackground(new Color(52, 73, 94));
        lblKeyA3.setBackground(new Color(155, 89, 182));
        new Thread(()
        -> {
        lblArray[0].setBackground(new Color(26, 188, 156));
        try {sleep(movingTime);} catch (Exception e) {}

            for (int i = 1; i < lblArray.length; i++) {
                lblKeyIndexA1.setText(" i = " + lblArray[i].getText());
                colourRest();
                lblArray[i].setBackground(new Color(26, 188, 156));
                try {sleep(movingTime);} catch (Exception e) {}

                for (int j = i; j > 0; j--) {
                    int pJ = Integer.parseInt(lblArray[j].getText());
                    int pJmin1 = Integer.parseInt(lblArray[j - 1].getText());

                    lblKeyIndexA2.setText(" j = " + pJ);
                    lblKeyIndexA3.setText(" j-1 = " + pJmin1);

                    colourRest();
                    lblArray[i].setBackground(new Color(26, 188, 156));
                    lblArray[j].setBackground(new Color(52, 73, 94));
                    lblArray[j - 1].setBackground(new Color(155, 89, 182));
                    try {sleep(movingTime);} catch (Exception e) {}

                    if (jrbAsc.isSelected()) {
                        if (pJ < pJmin1) {
                            lblHelp.setText("Is " + pJ + " < " + pJmin1);
                            lblHelpResult.setText("YES");
                            lblHelpResult.setForeground(new Color(46, 204, 113));
                            lblSwapResult.setText("SWAP " + pJ + " AND " + pJmin1);
                            try {sleep(movingTime);} catch (Exception e) {}

                            int d = Math.abs(lblArray[j - 1].getLocation().x - lblArray[j].getLocation().x);

                            for (int t = 0; t < d; t++) {
                                lblArray[j - 1].setLocation(lblArray[j - 1].getLocation().x + 1, lblArray[j - 1].getLocation().y);
                                lblArray[j].setLocation(lblArray[j].getLocation().x - 1, lblArray[j].getLocation().y);
                                try {sleep(aniTime);} catch (Exception e) {}
                            }

                            JLabel insJTemp = lblArray[j];
                            lblArray[j] = lblArray[j - 1];
                            lblArray[j - 1] = insJTemp;

                            lblKeyIndexA2.setText(" j = " + lblArray[j].getText());
                            lblKeyIndexA3.setText(" j-1 = " + lblArray[j - 1].getText());
                        }
                        lblHelp.setText("Is " + pJ + " < " + pJmin1);
                        lblHelpResult.setText("NO");
                        lblHelpResult.setForeground(new Color(231, 76, 60));
                        lblSwapResult.setText("DON'T swap " + pJ + " AND " + pJmin1);
                        try {sleep(movingTime);} catch (Exception e) {}
                    } else if (jrbDesc.isSelected()) {
                        if (pJ > pJmin1) {
                            lblHelp.setText("Is " + pJ + " > " + pJmin1);
                            lblHelpResult.setText("YES");
                            lblHelpResult.setForeground(new Color(46, 204, 113));
                            lblSwapResult.setText("SWAP " + pJ + " AND " + pJmin1);
                            try {sleep(movingTime);} catch (Exception e) {}

                            int d = Math.abs(lblArray[j - 1].getLocation().x - lblArray[j].getLocation().x);

                            for (int t = 0; t < d; t++) {
                                lblArray[j - 1].setLocation(lblArray[j - 1].getLocation().x + 1, lblArray[j - 1].getLocation().y);
                                lblArray[j].setLocation(lblArray[j].getLocation().x - 1, lblArray[j].getLocation().y);
                                try {sleep(aniTime);} catch (Exception e) {}
                            }

                            JLabel insJTemp = lblArray[j];
                            lblArray[j] = lblArray[j - 1];
                            lblArray[j - 1] = insJTemp;

                            lblKeyIndexA2.setText(" j = " + lblArray[j].getText());
                            lblKeyIndexA3.setText(" j-1 = " + lblArray[j - 1].getText());
                        }
                        lblHelp.setText("Is " + pJ + " > " + pJmin1);
                        lblHelpResult.setText("NO");
                        lblHelpResult.setForeground(new Color(231, 76, 60));
                        lblSwapResult.setText("DON'T swap " + pJ + " AND " + pJmin1);
                        try {sleep(movingTime);} catch (Exception e) {}
                    }
                }
                try {sleep(movingTime);} catch (Exception e) {}
            }
            colourRest();
            enableObjects();
            lblProgress.setText("Sorting Complete!");
            lblProgress.setBackground(new Color(39, 174, 96));
            lblHelp.setText("");
            lblHelpResult.setText("");
            lblSwapResult.setText("");
        }).start();
    }

    private void setISSource()
   {
       String source = "<html> \n" +
"public void doInsertionSort(int[] input){ <br>\n" +
"<br>\n" +
" int temp; <br>\n" +
"for (int i = 1; i < input.length; i++) { <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;  for(int j = i ; j > 0 ; j--){ <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  if(input[j] < input[j-1]){ <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; temp = input[j]; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  input[j] = input[j-1]; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  input[j-1] = temp; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp; } <br>\n" +
"}\n" +
"</html>";
       lblSource.setText(source);
   }
   
   private void setSSSource()
   {
        String source = "<html> \n" +
" public static int[] doSelectionSort(int[] arr){ <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;  for (int i = 0; i < arr.length - 1; i++) <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp; { <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int index = i; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for (int j = i + 1; j < arr.length; j++) <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  if (arr[j] < arr[index]) <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  index = j; <br> <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int smallerNumber = arr[index];  <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; arr[index] = arr[i]; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; arr[i] = smallerNumber; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;  } <br>\n" +
"} <br>\n" +
"</html>";
        lblSource.setText(source);
   }
   
   private void setBSSource()
   {
       String source ="<html> \n" +
"void bubbleSort(int[] intArray) { <br> \n" +
"int n = intArray.length; <br>\n" +
"int temp = 0; <br>\n" +
"for(int i=0; i < n; i++){ <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;for(int j=1; j < (n-i); j++){ <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; if(intArray[j-1] > intArray[j]){ <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;temp = intArray[j-1]; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;intArray[j-1] = intArray[j];<br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;intArray[j] = temp; <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;} <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <br>\n" +
"&nbsp;&nbsp;&nbsp;&nbsp;} <br>\n" +
"}<br>\n" +
"</html>";
       
       lblSource.setText(source);
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlBG = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        zlbl1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        lbl15 = new javax.swing.JLabel();
        lbl17 = new javax.swing.JLabel();
        lblHelp = new javax.swing.JLabel();
        lblHelpResult = new javax.swing.JLabel();
        lblSwapResult = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtValues = new javax.swing.JTextField();
        lblKeyA1 = new javax.swing.JLabel();
        lblKeyIndexA1 = new javax.swing.JLabel();
        lblKeyA2 = new javax.swing.JLabel();
        lblKeyIndexA2 = new javax.swing.JLabel();
        lblKeyA3 = new javax.swing.JLabel();
        lblKeyIndexA3 = new javax.swing.JLabel();
        lblSource = new javax.swing.JLabel();
        lblProgress = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlTitel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose3 = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRand = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jsSpeed = new javax.swing.JSlider();
        jButton10 = new javax.swing.JButton();
        jrbDesc = new javax.swing.JRadioButton();
        jrbAsc = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnInsertionSort = new javax.swing.JButton();
        btnSelectionSort = new javax.swing.JButton();
        btnBubbleSort = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Algorithm Simulator");
        setMinimumSize(new java.awt.Dimension(1120, 580));
        setUndecorated(true);

        pnlBG.setBackground(new java.awt.Color(236, 240, 241));

        jPanel2.setBackground(new java.awt.Color(236, 240, 241));
        jPanel2.setLayout(null);

        zlbl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        zlbl1.setForeground(new java.awt.Color(255, 255, 255));
        zlbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zlbl1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        zlbl1.setOpaque(true);
        jPanel2.add(zlbl1);
        zlbl1.setBounds(0, 0, 30, 250);

        lbl1.setBackground(new java.awt.Color(241, 196, 15));
        lbl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("250");
        lbl1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl1.setOpaque(true);
        jPanel2.add(lbl1);
        lbl1.setBounds(30, 0, 30, 250);

        lbl2.setBackground(new java.awt.Color(241, 196, 15));
        lbl2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("250");
        lbl2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl2.setOpaque(true);
        jPanel2.add(lbl2);
        lbl2.setBounds(60, 0, 30, 250);

        lbl3.setBackground(new java.awt.Color(241, 196, 15));
        lbl3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("250");
        lbl3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl3.setOpaque(true);
        jPanel2.add(lbl3);
        lbl3.setBounds(90, 0, 30, 250);

        lbl4.setBackground(new java.awt.Color(241, 196, 15));
        lbl4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("250");
        lbl4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl4.setOpaque(true);
        jPanel2.add(lbl4);
        lbl4.setBounds(120, 0, 30, 250);

        lbl5.setBackground(new java.awt.Color(241, 196, 15));
        lbl5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 255, 255));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setText("250");
        lbl5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl5.setOpaque(true);
        jPanel2.add(lbl5);
        lbl5.setBounds(150, 0, 30, 250);

        lbl6.setBackground(new java.awt.Color(241, 196, 15));
        lbl6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl6.setForeground(new java.awt.Color(255, 255, 255));
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setText("250");
        lbl6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl6.setOpaque(true);
        jPanel2.add(lbl6);
        lbl6.setBounds(180, 0, 30, 250);

        lbl7.setBackground(new java.awt.Color(241, 196, 15));
        lbl7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl7.setForeground(new java.awt.Color(255, 255, 255));
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setText("250");
        lbl7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl7.setOpaque(true);
        jPanel2.add(lbl7);
        lbl7.setBounds(210, 0, 30, 250);

        lbl8.setBackground(new java.awt.Color(241, 196, 15));
        lbl8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl8.setForeground(new java.awt.Color(255, 255, 255));
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setText("250");
        lbl8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl8.setOpaque(true);
        jPanel2.add(lbl8);
        lbl8.setBounds(240, 0, 30, 250);

        lbl9.setBackground(new java.awt.Color(241, 196, 15));
        lbl9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl9.setForeground(new java.awt.Color(255, 255, 255));
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setText("250");
        lbl9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl9.setOpaque(true);
        jPanel2.add(lbl9);
        lbl9.setBounds(270, 0, 30, 250);

        lbl10.setBackground(new java.awt.Color(241, 196, 15));
        lbl10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl10.setForeground(new java.awt.Color(255, 255, 255));
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setText("250");
        lbl10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl10.setOpaque(true);
        jPanel2.add(lbl10);
        lbl10.setBounds(300, 0, 30, 250);

        lbl11.setBackground(new java.awt.Color(241, 196, 15));
        lbl11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl11.setForeground(new java.awt.Color(255, 255, 255));
        lbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl11.setText("250");
        lbl11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl11.setOpaque(true);
        jPanel2.add(lbl11);
        lbl11.setBounds(330, 0, 30, 250);

        lbl12.setBackground(new java.awt.Color(241, 196, 15));
        lbl12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl12.setForeground(new java.awt.Color(255, 255, 255));
        lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl12.setText("250");
        lbl12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl12.setOpaque(true);
        jPanel2.add(lbl12);
        lbl12.setBounds(360, 0, 30, 250);

        lbl13.setBackground(new java.awt.Color(241, 196, 15));
        lbl13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl13.setForeground(new java.awt.Color(255, 255, 255));
        lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl13.setText("250");
        lbl13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl13.setOpaque(true);
        jPanel2.add(lbl13);
        lbl13.setBounds(390, 0, 30, 250);

        lbl14.setBackground(new java.awt.Color(241, 196, 15));
        lbl14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl14.setForeground(new java.awt.Color(255, 255, 255));
        lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl14.setText("250");
        lbl14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl14.setOpaque(true);
        jPanel2.add(lbl14);
        lbl14.setBounds(420, 0, 30, 250);

        lbl15.setBackground(new java.awt.Color(241, 196, 15));
        lbl15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl15.setForeground(new java.awt.Color(255, 255, 255));
        lbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl15.setText("250");
        lbl15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl15.setOpaque(true);
        jPanel2.add(lbl15);
        lbl15.setBounds(450, 0, 30, 250);

        lbl17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl17.setForeground(new java.awt.Color(255, 255, 255));
        lbl17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbl17.setOpaque(true);
        jPanel2.add(lbl17);
        lbl17.setBounds(480, 0, 30, 250);

        lblHelp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp.setText("Info");
        jPanel2.add(lblHelp);
        lblHelp.setBounds(30, 260, 450, 32);

        lblHelpResult.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblHelpResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelpResult.setText("YES/NO");
        jPanel2.add(lblHelpResult);
        lblHelpResult.setBounds(110, 290, 300, 48);

        lblSwapResult.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSwapResult.setForeground(new java.awt.Color(52, 73, 94));
        lblSwapResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSwapResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel2.add(lblSwapResult);
        lblSwapResult.setBounds(110, 340, 300, 40);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter 15 Numbers Between 0 - 250");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 440, 420, 16);

        txtValues.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtValues);
        txtValues.setBounds(30, 470, 450, 26);

        lblKeyA1.setBackground(new java.awt.Color(51, 51, 51));
        lblKeyA1.setOpaque(true);
        jPanel2.add(lblKeyA1);
        lblKeyA1.setBounds(40, 390, 20, 20);

        lblKeyIndexA1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKeyIndexA1.setText("i =");
        jPanel2.add(lblKeyIndexA1);
        lblKeyIndexA1.setBounds(70, 390, 90, 20);

        lblKeyA2.setBackground(new java.awt.Color(51, 51, 51));
        lblKeyA2.setOpaque(true);
        jPanel2.add(lblKeyA2);
        lblKeyA2.setBounds(190, 390, 20, 20);

        lblKeyIndexA2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKeyIndexA2.setText("j =");
        jPanel2.add(lblKeyIndexA2);
        lblKeyIndexA2.setBounds(220, 390, 90, 20);

        lblKeyA3.setBackground(new java.awt.Color(51, 51, 51));
        lblKeyA3.setOpaque(true);
        jPanel2.add(lblKeyA3);
        lblKeyA3.setBounds(350, 390, 20, 20);

        lblKeyIndexA3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKeyIndexA3.setText("index =");
        jPanel2.add(lblKeyIndexA3);
        lblKeyIndexA3.setBounds(380, 390, 90, 20);

        lblSource.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblSource.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSource.setText("<html>  public void doInsertionSort(int[] input){ <br> <br>  int temp; <br> for (int i = 1; i < input.length; i++) { <br> &nbsp;&nbsp;&nbsp;&nbsp;  for(int j = i ; j > 0 ; j--){ <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  if(input[j] < input[j-1]){ <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; temp = input[j]; <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  input[j] = input[j-1]; <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;  input[j-1] = temp; <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <br> &nbsp;&nbsp;&nbsp;&nbsp; } <br> } </html>");
        jPanel2.add(lblSource);
        lblSource.setBounds(510, 90, 380, 350);

        lblProgress.setBackground(new java.awt.Color(236, 240, 241));
        lblProgress.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblProgress.setForeground(new java.awt.Color(236, 240, 241));
        lblProgress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProgress.setText("---------------");
        lblProgress.setOpaque(true);
        jPanel2.add(lblProgress);
        lblProgress.setBounds(540, 30, 320, 50);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Design and Analysis of Algorithms IT240 Assignment ");
        jLabel4.setToolTipText("");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel4);
        jLabel4.setBounds(600, 490, 290, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Perera.P.D.S");
        jLabel5.setToolTipText("");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel5);
        jLabel5.setBounds(770, 450, 120, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IT14031380");
        jLabel6.setToolTipText("");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel6);
        jLabel6.setBounds(770, 470, 120, 20);

        javax.swing.GroupLayout pnlBGLayout = new javax.swing.GroupLayout(pnlBG);
        pnlBG.setLayout(pnlBGLayout);
        pnlBGLayout.setHorizontalGroup(
            pnlBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBGLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBGLayout.setVerticalGroup(
            pnlBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlTitel.setBackground(new java.awt.Color(0, 0, 0));
        pnlTitel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTitelMousePressed(evt);
            }
        });
        pnlTitel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" DAA Algorithm Simulator");
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        pnlTitel.add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 30);

        btnClose3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/close.png"))); // NOI18N
        btnClose3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        pnlTitel.add(btnClose3);
        btnClose3.setBounds(870, 0, 30, 30);

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/minimize.png"))); // NOI18N
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        pnlTitel.add(btnMinimize);
        btnMinimize.setBounds(850, 0, 20, 30);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setLayout(null);

        btnRand.setBackground(new java.awt.Color(155, 89, 182));
        btnRand.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnRand.setForeground(new java.awt.Color(255, 255, 255));
        btnRand.setText("Generate Random Data List");
        btnRand.setBorder(null);
        btnRand.setBorderPainted(false);
        btnRand.setContentAreaFilled(false);
        btnRand.setFocusable(false);
        btnRand.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRand.setOpaque(true);
        btnRand.setPreferredSize(new java.awt.Dimension(145, 30));
        btnRand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandActionPerformed(evt);
            }
        });
        jPanel1.add(btnRand);
        btnRand.setBounds(0, 0, 190, 30);

        jButton8.setBackground(new java.awt.Color(149, 165, 166));
        jButton8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Clear");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setOpaque(true);
        jButton8.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(490, 0, 130, 30);

        jsSpeed.setBackground(new java.awt.Color(51, 51, 51));
        jsSpeed.setForeground(new java.awt.Color(0, 0, 0));
        jsSpeed.setPaintLabels(true);
        jsSpeed.setPaintTicks(true);
        jsSpeed.setValue(0);
        jsSpeed.setFocusable(false);
        jsSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsSpeedStateChanged(evt);
            }
        });
        jsSpeed.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jsSpeedMouseMoved(evt);
            }
        });
        jPanel1.add(jsSpeed);
        jsSpeed.setBounds(720, 0, 180, 30);

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Speed");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setOpaque(true);
        jButton10.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(620, 0, 100, 30);

        jrbDesc.setBackground(new java.awt.Color(52, 73, 94));
        buttonGroup1.add(jrbDesc);
        jrbDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jrbDesc.setForeground(new java.awt.Color(255, 255, 255));
        jrbDesc.setText("Descending Order");
        jrbDesc.setFocusPainted(false);
        jPanel1.add(jrbDesc);
        jrbDesc.setBounds(320, 0, 140, 30);

        jrbAsc.setBackground(new java.awt.Color(52, 73, 94));
        buttonGroup1.add(jrbAsc);
        jrbAsc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jrbAsc.setForeground(new java.awt.Color(255, 255, 255));
        jrbAsc.setSelected(true);
        jrbAsc.setText("Ascending Order");
        jrbAsc.setFocusPainted(false);
        jPanel1.add(jrbAsc);
        jrbAsc.setBounds(200, 0, 120, 30);

        jPanel3.setLayout(null);

        btnInsertionSort.setBackground(new java.awt.Color(57, 54, 61));
        btnInsertionSort.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnInsertionSort.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertionSort.setText("Insertion Sort");
        btnInsertionSort.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnInsertionSort.setContentAreaFilled(false);
        btnInsertionSort.setFocusable(false);
        btnInsertionSort.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInsertionSort.setOpaque(true);
        btnInsertionSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertionSortMouseClicked(evt);
            }
        });
        btnInsertionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertionSortActionPerformed(evt);
            }
        });
        jPanel3.add(btnInsertionSort);
        btnInsertionSort.setBounds(20, 360, 180, 30);

        btnSelectionSort.setBackground(new java.awt.Color(57, 54, 61));
        btnSelectionSort.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnSelectionSort.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectionSort.setText("Selection Sort");
        btnSelectionSort.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSelectionSort.setContentAreaFilled(false);
        btnSelectionSort.setFocusable(false);
        btnSelectionSort.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSelectionSort.setOpaque(true);
        btnSelectionSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectionSortMouseClicked(evt);
            }
        });
        jPanel3.add(btnSelectionSort);
        btnSelectionSort.setBounds(20, 400, 180, 30);

        btnBubbleSort.setBackground(new java.awt.Color(57, 54, 61));
        btnBubbleSort.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnBubbleSort.setForeground(new java.awt.Color(255, 255, 255));
        btnBubbleSort.setText("Bubble Sort");
        btnBubbleSort.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnBubbleSort.setContentAreaFilled(false);
        btnBubbleSort.setFocusable(false);
        btnBubbleSort.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBubbleSort.setOpaque(true);
        btnBubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBubbleSortActionPerformed(evt);
            }
        });
        jPanel3.add(btnBubbleSort);
        btnBubbleSort.setBounds(20, 440, 180, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sri Lanka");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(0, 530, 220, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Institute of Information Technology ");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(0, 550, 220, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Artwork.png"))); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 0, 220, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      txtValues.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnInsertionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertionSortActionPerformed
     
    }//GEN-LAST:event_btnInsertionSortActionPerformed

    private void btnBubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBubbleSortActionPerformed
        
        if(setArray())
        {
              BubbleSort();
        }
      
    }//GEN-LAST:event_btnBubbleSortActionPerformed

    private void btnSelectionSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectionSortMouseClicked
       
        if(setArray())
        {
              SelectionSort();
        }
      
    }//GEN-LAST:event_btnSelectionSortMouseClicked

    private void btnInsertionSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertionSortMouseClicked
        if(setArray())
        {
             InsertionSort();
        }
       
    }//GEN-LAST:event_btnInsertionSortMouseClicked

    private void pnlTitelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitelMousePressed

    }//GEN-LAST:event_pnlTitelMousePressed

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
       
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        xMousePos = evt.getX();
        yMousePos = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        int ScreenX =  evt.getXOnScreen();
        int ScreeY = evt.getYOnScreen();

        this.setLocation(ScreenX - xMousePos, ScreeY - yMousePos);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void jsSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsSpeedStateChanged
       setSpeed();
    }//GEN-LAST:event_jsSpeedStateChanged

    private void jsSpeedMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsSpeedMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jsSpeedMouseMoved

    private void btnRandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandActionPerformed
        generateRandomDataList();
        displayArr();
    }//GEN-LAST:event_btnRandActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBubbleSort;
    public static javax.swing.JLabel btnClose;
    public static javax.swing.JLabel btnClose1;
    private javax.swing.JLabel btnClose3;
    private javax.swing.JButton btnInsertionSort;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnRand;
    private javax.swing.JButton btnSelectionSort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jrbAsc;
    private javax.swing.JRadioButton jrbDesc;
    private javax.swing.JSlider jsSpeed;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl17;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblHelpResult;
    private javax.swing.JLabel lblKeyA1;
    private javax.swing.JLabel lblKeyA2;
    private javax.swing.JLabel lblKeyA3;
    private javax.swing.JLabel lblKeyIndexA1;
    private javax.swing.JLabel lblKeyIndexA2;
    private javax.swing.JLabel lblKeyIndexA3;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JLabel lblSource;
    private javax.swing.JLabel lblSwapResult;
    private javax.swing.JPanel pnlBG;
    private javax.swing.JPanel pnlTitel;
    private javax.swing.JPanel titleBar;
    private javax.swing.JPanel titleBar1;
    private javax.swing.JTextField txtValues;
    private javax.swing.JLabel zlbl1;
    // End of variables declaration//GEN-END:variables
}
