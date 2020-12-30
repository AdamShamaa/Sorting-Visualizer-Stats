package GUI;

import GUIComponents.ArrayAccessesJTextField;
import GUIComponents.ArrayComparesJTextField;
import GUIComponents.sortingJPanel;
import sortAlgorithim.MasterSortingFile;

/**
 *@author AdamShamaa
 **/
public class GUIJFrame extends javax.swing.JFrame {
	private MasterSortingFile sortingFile = new MasterSortingFile();	//used to retrieve the sorting algorithm names which are automatically inputed into the GUI
	
    //Initialize JFrame
    public GUIJFrame() {
        initComponents();
    }
    private void initComponents() {
    	/* Initialization */
    	//JLabels
        applicationJLabel = new javax.swing.JLabel(); 
        comparesJLabel = new javax.swing.JLabel();
        arrayAccessesJLabel = new javax.swing.JLabel();
        arraySizeJLabel = new javax.swing.JLabel();
        sortSpeedJLabel = new javax.swing.JLabel();
        delayJLabel = new javax.swing.JLabel();
        
        //Panels
        controlPanel = new javax.swing.JPanel();
        sortingJPanel = new sortingJPanel();
        
        //Buttons
        restartButton = new javax.swing.JButton();
        sortButton = new javax.swing.JButton();
        shuffleButton = new javax.swing.JButton();
        
        //Sliders
        speedSlider = new javax.swing.JSlider();
        sizeSlider = new javax.swing.JSlider();
        
        //ComboBox
        sortingMethodComboBox = new javax.swing.JComboBox<>();
       
        //TextFields
        arrayComparesJTextField = new ArrayComparesJTextField();
        arrayAccessesJTextField = new ArrayAccessesJTextField();
        delayTextField = new javax.swing.JFormattedTextField();      

        //Window Attributes
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));

        /*SET Slider Attributes*/
        speedSlider.setMaximum(150);
        speedSlider.setValue(20);
        speedSlider.setInverted(true);
        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        sizeSlider.setMajorTickSpacing(10);
        sizeSlider.setMaximum(1000);
        sizeSlider.setMinorTickSpacing(10);
        sizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sizeSliderStateChanged(evt);
            }
        });

        /*SET Button Attributes*/
        restartButton.setText("Restart");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        sortButton.setText("Sort");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        shuffleButton.setText("Shuffle");
        shuffleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleButtonActionPerformed(evt);
            }
        });
        
        /*SET ComboBox Attributes*/
        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(sortingFile.getArrayOfSortingAlgorithimNames()));

        /*SET Control Panel Attributes*/
        controlPanel.setMaximumSize(new java.awt.Dimension(752, 490));

        /*SET JPanel Attributes*/
        sortingJPanel.setPreferredSize(new java.awt.Dimension(0, 500));
        javax.swing.GroupLayout liveSortPanelLayout = new javax.swing.GroupLayout(sortingJPanel);
        sortingJPanel.setLayout(liveSortPanelLayout);
        liveSortPanelLayout.setHorizontalGroup(
                liveSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 712, Short.MAX_VALUE)
                );
        liveSortPanelLayout.setVerticalGroup(
                liveSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 391, Short.MAX_VALUE)
                );

        /*SET Label Attributes*/
        delayJLabel.setText("Delay:");
        
        arraySizeJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        arraySizeJLabel.setText("Array Size");

        sortSpeedJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        sortSpeedJLabel.setText("Sort Speed");
        
        arrayAccessesJLabel.setText("Array Accesses:");
        
        comparesJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comparesJLabel.setText("Compares:");
        
        applicationJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        applicationJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        applicationJLabel.setText("Sorting Visualizer");

        /*SET Text Field Attributes*/
        delayTextField.setBackground(new java.awt.Color(238, 238, 238));
        delayTextField.setBorder(null);
        delayTextField.setText("0");
        
        arrayComparesJTextField.setBackground(new java.awt.Color(238, 238, 238));
        arrayComparesJTextField.setBorder(null);
        arrayComparesJTextField.setText("0");

        arrayAccessesJTextField.setBackground(new java.awt.Color(238, 238, 238));
        arrayAccessesJTextField.setBorder(null);
        arrayAccessesJTextField.setText("0");

        /* Mount to JFrame (Automatically Done by NetBeans) */
        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(controlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(controlPanelLayout.createSequentialGroup()
                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(comparesJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(arrayComparesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(arrayAccessesJLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(arrayAccessesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(delayJLabel)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(delayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(141, 141, 141))
                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                                        .addComponent(sortingMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, controlPanelLayout.createSequentialGroup() //
                                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                                        .addComponent(arraySizeJLabel)
                                                                        .addGap(51, 51, 51)))
                                                        .addComponent(applicationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                                        .addGap(44, 44, 44)
                                                                        .addComponent(sortSpeedJLabel)))))
                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                        .addGap(34, 34, 34)
                                                        .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(470, 470, 470))
                                .addGroup(controlPanelLayout.createSequentialGroup()
                                        .addComponent(sortingJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
        controlPanelLayout.setVerticalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(controlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(controlPanelLayout.createSequentialGroup()
                                        .addComponent(arraySizeJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(sizeSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(sortingMethodComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48))
                                .addGroup(controlPanelLayout.createSequentialGroup()
                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(applicationJLabel))
                                                .addGroup(controlPanelLayout.createSequentialGroup()
                                                        .addComponent(sortSpeedJLabel)
                                                        .addGap(2, 2, 2)
                                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(restartButton)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(shuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(comparesJLabel)
                                                        .addComponent(arrayComparesJTextField)
                                                        .addComponent(arrayAccessesJLabel)
                                                        .addComponent(arrayAccessesJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(delayJLabel)
                                                        .addComponent(delayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(sortingJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()    
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Action-Performed
    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {   //sort button pressed
        startSort();
    }

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) { //restart button
        restartSameSortPanel();
    }
    
    private void sizeSliderStateChanged(javax.swing.event.ChangeEvent evt) {    //size slider moved
        randomizeSortPanel();
    }

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {   //speed slider moved
        updateSortSpeed();
    }

    private void shuffleButtonActionPerformed(java.awt.event.ActionEvent evt) { //shuffle button pressed
        randomizeSortPanel();
    }
    
    //configuration-methods
    private boolean isSorting;
    private String sortType;
    
    public void initializeJPanel() {
        sizeSlider.setMaximum(sortingJPanel.getWidth());
        sortingJPanel.initialize(sizeSlider.getValue(), arrayComparesJTextField, arrayAccessesJTextField); 
    }
    
    private void restartSameSortPanel() {  	//reset the array to its initial values WITHOUT re-shuffling
        sortingJPanel.array.restartSameArray();   
        initalizeSortPanel();
    }
    
    private void initalizeSortPanel() { //re-initialize counters to their default values (0)
        sortingJPanel.resetJTextFieldCounts();
        sortingJPanel.repaint();
        sortingJPanel.validate();
    }

    private void randomizeSortPanel() { //randomize the unsorted array
        sortingJPanel.setSize(sizeSlider.getValue());
        initalizeSortPanel();
    }
    
    private void updateSortSpeed() {   //update the delay to the new value set by the slider
        sortingJPanel.setSpeed((speedSlider.getValue())*0.5);
        if (isSorting) delayTextField.setText(speedSlider.getValue() * 0.5 + " ms");
    }
    
    private void startSort() {	//Initiate the sort sequence (see main function)
        sortType = sortingMethodComboBox.getSelectedItem().toString();
        isSorting = true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIJFrame JFrame = new GUIJFrame();
        JFrame.setVisible(true);
        JFrame.initializeJPanel();
        while (true) {  //check if sort-button pressed
            JFrame.delayTextField.setText(JFrame.speedSlider.getValue()*0.5 + " ms"); //update delay
            if (JFrame.isSorting == true) { 
                JFrame.sortingJPanel.startSort(JFrame.sortType);
                JFrame.isSorting = false;
            }
            JFrame.validate();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel applicationJLabel;
    private javax.swing.JLabel arrayAccessesJLabel;
    private javax.swing.JLabel comparesJLabel;
    private javax.swing.JLabel arraySizeJLabel;
    private javax.swing.JLabel sortSpeedJLabel;
    private javax.swing.JLabel delayJLabel;
    private sortingJPanel sortingJPanel;  
    private javax.swing.JPanel controlPanel;
    private javax.swing.JFormattedTextField delayTextField;
    private ArrayAccessesJTextField arrayAccessesJTextField;
    private ArrayComparesJTextField arrayComparesJTextField;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton shuffleButton;
    private javax.swing.JButton sortButton;
    private javax.swing.JComboBox<String> sortingMethodComboBox;
    private javax.swing.JSlider sizeSlider;
    private javax.swing.JSlider speedSlider;
}
