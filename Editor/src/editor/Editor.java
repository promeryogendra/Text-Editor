
package editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.UndoableEditEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;

public class Editor extends javax.swing.JFrame {
	
	int a=0;
	boolean searchoption=false;
	newTab currentObject;
	public static final List<newTab> list=new ArrayList<>();
	public Editor() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(this);
		setTitle("RR Editor");
		
		tabbedpane.addChangeListener((ChangeEvent e) -> {
			if(tabbedpane.getTabCount()!=0)
			{
				currentObject=list.get(tabbedpane.getSelectedIndex());
			}
		});
		
	}
	

	public void add()
	{
		JTextArea area=new JTextArea();
        UndoManager manager=new UndoManager();
        area.getDocument().addUndoableEditListener((UndoableEditEvent uee) -> {
			manager.addEdit(uee.getEdit());
		});
		
		area.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent ke) {
				
			}

			@Override
			public void keyPressed(KeyEvent ke) {
				
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				currentObject.save=true;
				if(currentObject!=null && searchoption==true && !searchfield.getText().trim().equals(""))
				{
					hilight();
				}
			}
			
		});
		
		area.setSize(30,30);
		CustomTabComponent customTabComponent=new CustomTabComponent(tabbedpane, "Untitiled");
		
		Highlighter h = area.getHighlighter();
		newTab newtab=new newTab(false,"tab",null,manager,area,customTabComponent,h);
		list.add(newtab);
		
		area.setBackground(new java.awt.Color(22, 69, 85));
		area.setColumns(20);
		area.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        area.setForeground(java.awt.Color.white);
        area.setRows(5);
		
		area.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
			}

			@Override
			public void mousePressed(MouseEvent me) {
			}

			@Override
			public void mouseReleased(MouseEvent me) {
				
				if(currentObject!=null && SwingUtilities.isRightMouseButton(me))
					{
						if(currentObject.undomanager.canRedo())
							redo.setEnabled(true);
						else
							redo.setEnabled(false);
						if(currentObject.undomanager.canUndo())
							undo.setEnabled(true);
						else
							undo.setEnabled(false);
						if(currentObject.textarea.getSelectedText()!=null)
						{
							copy.setEnabled(true);
							cut.setEnabled(true);
						}
						else
						{
							copy.setEnabled(false);
							cut.setEnabled(false);
						}
						popup.add(cut);
						popup.show(me.getComponent(),me.getX(),me.getY());
					}
				
			}

			@Override
			public void mouseEntered(MouseEvent me) {
			}

			@Override
			public void mouseExited(MouseEvent me) {
			}
		});
		newtab.save=true;
		tabbedpane.addTab(null,new JScrollPane(area));
		tabbedpane.setTabComponentAt(tabbedpane.getTabCount()-1,customTabComponent);
		if(a==0)
		{
			a=1;
			currentObject=newtab;
		}
	}
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();
        selectall = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        tabbedpane = new javax.swing.JTabbedPane();
        footer = new javax.swing.JPanel();
        searchfield = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        replace = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        open = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        selectmenu = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        copymenu = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        cutmenu = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        findmenu = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        selectmenu1 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        pastemenu = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        undomenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        redomenu = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Cut_20px.png"))); // NOI18N
        cut.setText("Cut");
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        popup.add(cut);

        copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Copy_20px.png"))); // NOI18N
        copy.setText("Copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        popup.add(copy);

        paste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Paste_20px.png"))); // NOI18N
        paste.setText("Paste");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });
        popup.add(paste);

        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Undo_20px.png"))); // NOI18N
        undo.setText("Undo");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        popup.add(undo);

        redo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Redo_20px_1.png"))); // NOI18N
        redo.setText("Redo");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });
        popup.add(redo);

        selectall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Select_All_20px.png"))); // NOI18N
        selectall.setText("SelectAll");
        selectall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectallActionPerformed(evt);
            }
        });
        popup.add(selectall);

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(tabbedpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 490));

        searchfield.setBackground(new java.awt.Color(18, 159, 209));
        searchfield.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        searchfield.setForeground(new java.awt.Color(0, 0, 0));
        searchfield.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchfield.setToolTipText("Search");
        searchfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfieldActionPerformed(evt);
            }
        });

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Search_30px_1.png"))); // NOI18N
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchMouseExited(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear Seach");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Replace All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Replace");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        replace.setBackground(new java.awt.Color(18, 159, 209));
        replace.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        replace.setForeground(new java.awt.Color(0, 0, 0));
        replace.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        replace.setToolTipText("Search");
        replace.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        replace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(replace, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchfield)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton2)
                .addComponent(jButton3))
            .addComponent(replace)
        );

        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 820, 30));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Open_30px_1.png"))); // NOI18N
        jMenu1.setText("File");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.add(jSeparator9);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Add_File_20px_1.png"))); // NOI18N
        jMenuItem11.setText("New");
        jMenuItem11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);
        jMenu1.add(jSeparator4);

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Documents_Folder_20px.png"))); // NOI18N
        open.setText("Open");
        open.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jMenu1.add(open);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Save_20px.png"))); // NOI18N
        jMenuItem2.setText("Save");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator3);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Save_as_20px.png"))); // NOI18N
        jMenuItem3.setText("SaveAs");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator5);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Close_Program_20px.png"))); // NOI18N
        jMenuItem1.setText("Close");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator7);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Close_Window_20px.png"))); // NOI18N
        jMenuItem10.setText("Quit");
        jMenuItem10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);
        jMenu1.add(jSeparator8);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Edit_File_30px.png"))); // NOI18N
        jMenu2.setText("Edit");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenu2.add(jSeparator10);

        selectmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Select_All_20px.png"))); // NOI18N
        selectmenu.setText("Select All");
        selectmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectmenuActionPerformed(evt);
            }
        });
        jMenu2.add(selectmenu);
        jMenu2.add(jSeparator6);

        copymenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copymenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Copy_20px.png"))); // NOI18N
        copymenu.setText("Copy");
        copymenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copymenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copymenuActionPerformed(evt);
            }
        });
        jMenu2.add(copymenu);
        jMenu2.add(jSeparator14);

        cutmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Cut_20px.png"))); // NOI18N
        cutmenu.setText("Cut");
        cutmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cutmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutmenuActionPerformed(evt);
            }
        });
        jMenu2.add(cutmenu);
        jMenu2.add(jSeparator11);

        findmenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        findmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Search_20px_2.png"))); // NOI18N
        findmenu.setText("Find");
        findmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        findmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findmenuActionPerformed(evt);
            }
        });
        jMenu2.add(findmenu);
        jMenu2.add(jSeparator16);

        selectmenu1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        selectmenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Replace_20px_2.png"))); // NOI18N
        selectmenu1.setText("Replace");
        selectmenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectmenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectmenu1ActionPerformed(evt);
            }
        });
        jMenu2.add(selectmenu1);
        jMenu2.add(jSeparator15);

        pastemenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pastemenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Paste_20px.png"))); // NOI18N
        pastemenu.setText("Paste");
        pastemenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pastemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastemenuActionPerformed(evt);
            }
        });
        jMenu2.add(pastemenu);
        jMenu2.add(jSeparator12);

        undomenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undomenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Undo_20px.png"))); // NOI18N
        undomenu.setText("Undo");
        undomenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        undomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undomenuActionPerformed(evt);
            }
        });
        jMenu2.add(undomenu);
        jMenu2.add(jSeparator2);

        redomenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        redomenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_Redo_20px_1.png"))); // NOI18N
        redomenu.setText("Redo");
        redomenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        redomenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redomenuActionPerformed(evt);
            }
        });
        jMenu2.add(redomenu);
        jMenu2.add(jSeparator13);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_About_30px.png"))); // NOI18N
        jMenu4.setText("About");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editor/images/icons8_About_30px.png"))); // NOI18N
        jMenuItem12.setText("About");
        jMenuItem12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed

		JFileChooser chooser=new JFileChooser(System.getProperty("user.home") + "/Desktop");
		int success=chooser.showOpenDialog(null);
		if(success==JFileChooser.APPROVE_OPTION && chooser.getSelectedFile().getAbsolutePath().endsWith(".txt"))
		{
			File file=chooser.getSelectedFile();
			currentObject.filename=file.getName();
			currentObject.realfile=file;
			try {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String s=br.readLine();
					while(s!=null)
					{
						currentObject.textarea.append(s+"\n");
						s=br.readLine();
					}
				}
				newTab tab=(newTab)list.get(tabbedpane.getSelectedIndex());
				tab.filename=currentObject.filename;
				tab.realfile=currentObject.realfile;
				tab.customTabComponent.titleLabel.setText(currentObject.filename);
			} catch (FileNotFoundException ex) {
				
			} catch (IOException ex) {
				
			}
			
		}
        
    }//GEN-LAST:event_openActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

		
		if(currentObject!=null && currentObject.save==true  && currentObject.realfile!=null)
		{
			try {
				String ln = System.getProperty("line.separator");
				FileWriter fw=new FileWriter(currentObject.realfile);
				fw.write(currentObject.textarea.getText().replaceAll("\n", ln));
				currentObject.save=false;
				list.get(tabbedpane.getSelectedIndex()).save=false;
				fw.close();
			} catch (IOException ex) {			
				
				JOptionPane.showMessageDialog(this, ex.getMessage());

			}
		}
		if(currentObject!=null && currentObject.save==true && currentObject.realfile==null)
		{
			
			JFileChooser chooser=new JFileChooser(System.getProperty("user.home") + "/Desktop");
			chooser.setFileFilter(new FileFilter() {
				@Override
				public boolean accept(File file) {
					if(file.isDirectory())
						return true;
					return file.getName().endsWith(".txt");
				}

				@Override
				public String getDescription() {
					return "Text Document"+String.format("*%s",".txt");
				}
			});
			chooser.setDialogTitle("Save File");
			int re=chooser.showSaveDialog(null);
			if(re==JFileChooser.APPROVE_OPTION)
			{
				String cont=currentObject.textarea.getText();
				File f=chooser.getSelectedFile();
				try {
					String ln = System.getProperty("line.separator");
					FileWriter fw=new FileWriter(f);
					fw.write(cont.replaceAll("\n", ln));
					fw.flush();
					fw.close();
					currentObject.realfile=chooser.getSelectedFile();
					currentObject.save=false;
					currentObject.filename=currentObject.realfile.getName();
					currentObject.customTabComponent.titleLabel.setText(currentObject.filename);
				} catch (IOException ex) {
					
				}
			}
		}
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

		
		JFileChooser chooser=new JFileChooser(System.getProperty("user.home") + "/Desktop");
		chooser.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File file) {
				if(file.isDirectory())
					return true;
				return file.getName().endsWith(".txt");
			}

			@Override
			public String getDescription() {
				return "Text Document"+String.format("*%s",".exe");
			}
		});
		chooser.setDialogTitle("Save File As");
		int re=chooser.showSaveDialog(null);
		if(re==JFileChooser.APPROVE_OPTION)
		{
			String cont=currentObject.textarea.getText();
			File f=chooser.getSelectedFile();
			try {
				String ln = System.getProperty("line.separator");
				FileWriter fw=new FileWriter(f);
				fw.write(cont.replaceAll("\n", ln));
				fw.flush();
				fw.close();
				currentObject.realfile=chooser.getSelectedFile();
				currentObject.save=false;
				currentObject.filename=chooser.getSelectedFile().getAbsolutePath();
				currentObject.customTabComponent.titleLabel.setText(currentObject.filename);
			} catch (IOException ex) {
			}
		}
		
		
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		if(tabbedpane.getTabCount()!=0)
		{
			list.remove(tabbedpane.getSelectedIndex());
			tabbedpane.removeTabAt(tabbedpane.getSelectedIndex());
			
		}
		
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
		
		System.exit(0);
		
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void selectmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectmenuActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.selectAll();
		}

    }//GEN-LAST:event_selectmenuActionPerformed

    private void copymenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copymenuActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.copy();
		}
		
    }//GEN-LAST:event_copymenuActionPerformed

    private void cutmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutmenuActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.cut();
		}

    }//GEN-LAST:event_cutmenuActionPerformed

    private void pastemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastemenuActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.paste();
		}
    }//GEN-LAST:event_pastemenuActionPerformed

    private void undomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undomenuActionPerformed

        if(currentObject!=null && currentObject.undomanager.canUndo())
        {
            currentObject.undomanager.undo();
        }

    }//GEN-LAST:event_undomenuActionPerformed

    private void redomenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redomenuActionPerformed

        if(currentObject!=null &&currentObject.undomanager.canRedo())
        {
            currentObject.undomanager.redo();
        }

    }//GEN-LAST:event_redomenuActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.cut();
		}
    }//GEN-LAST:event_cutActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.copy();
		}
    }//GEN-LAST:event_copyActionPerformed

    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.paste();
		}
    }//GEN-LAST:event_pasteActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed

        undomenuActionPerformed(evt);

    }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed

        redomenuActionPerformed(evt);

    }//GEN-LAST:event_redoActionPerformed

    private void selectallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectallActionPerformed
		if(currentObject!=null)
		{
			currentObject.textarea.selectAll();
		}
    }//GEN-LAST:event_selectallActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        add();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        
		
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        
		About about=new About();
		about.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfieldActionPerformed

    private void searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseEntered
        
		search.setBackground(Color.GRAY);
		
    }//GEN-LAST:event_searchMouseEntered

    private void searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseExited
        
		search.setBackground(Color.WHITE);
		
    }//GEN-LAST:event_searchMouseExited

	public void hilight()
	{
		String myWord = searchfield.getText();
		Highlighter h = currentObject.h;
		h.removeAllHighlights();
		int position=0;
		while((position=currentObject.textarea.getText().toUpperCase().indexOf(myWord.toUpperCase(),position))>=0)
		{
			try {
				h.addHighlight(position,position+myWord.length(),DefaultHighlighter.DefaultPainter);
			} catch (BadLocationException ex) {
				
			}
			position+=myWord.length();
		}
	}
    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
       if(currentObject!=null && !searchfield.getText().trim().equals(""))
	   {
			hilight();
			searchoption=true;
	   }
    }//GEN-LAST:event_searchMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		if(currentObject!=null)
		{
			
			Highlighter h = currentObject.textarea.getHighlighter();
			h.removeAllHighlights();
			searchoption=false;
			searchfield.setText("");
		}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

		if(currentObject==null)
		{
			JOptionPane.showMessageDialog(this, "Open A New File First.");
		}
		else
		{
			if(searchfield.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Enter Text To Be replaced in Searh Field");
			}
			else
			{
				if(replace.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Enter Text To Replace");
				}
				else
				{
					String rp=replace.getText();
					String sc=searchfield.getText();
					String text=currentObject.textarea.getText();
					currentObject.textarea.setText(text.replace(sc, rp));
					searchfield.setText("");
					replace.setText("");
				}
			}
		}
		
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
		if(currentObject!=null && currentObject.textarea.getSelectedText() != null &&  !replace.getText().trim().equals(""))
		{
			currentObject.textarea.replaceSelection(replace.getText());
			replace.setText("");
		}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void replaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_replaceActionPerformed

    private void findmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findmenuActionPerformed
		searchfield.requestFocus();
		if(currentObject!=null)
		{
			
			Highlighter h = currentObject.textarea.getHighlighter();
			h.removeAllHighlights();
			searchoption=false;
			searchfield.setText("");
		}
    }//GEN-LAST:event_findmenuActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

		
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void selectmenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectmenu1ActionPerformed
        replace.requestFocus();
    }//GEN-LAST:event_selectmenu1ActionPerformed

	public static void main(String args[]) {
		
		java.awt.EventQueue.invokeLater(() -> {
			new Editor().setVisible(true);
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem copymenu;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem cutmenu;
    private javax.swing.JMenuItem findmenu;
    private javax.swing.JPanel footer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem pastemenu;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JMenuItem redo;
    private javax.swing.JMenuItem redomenu;
    private javax.swing.JTextField replace;
    private javax.swing.JLabel search;
    private javax.swing.JTextField searchfield;
    private javax.swing.JMenuItem selectall;
    private javax.swing.JMenuItem selectmenu;
    private javax.swing.JMenuItem selectmenu1;
    private javax.swing.JTabbedPane tabbedpane;
    private javax.swing.JMenuItem undo;
    private javax.swing.JMenuItem undomenu;
    // End of variables declaration//GEN-END:variables
}
class newTab
{
	boolean save=false;
	String filename=null;
	File realfile=null;
	UndoManager undomanager=null;
	JTextArea textarea=null;
	CustomTabComponent customTabComponent=null;
	Highlighter h=null;
	public newTab(boolean save,String filenname,File realfile,UndoManager undomanager,JTextArea textarea,CustomTabComponent customTabComponent,Highlighter h)
	{
		this.save=save;
		this.filename=filenname;
		this.realfile=realfile;
		this.undomanager=undomanager;
		this.textarea=textarea;
		this.customTabComponent=customTabComponent;
		this.h=h;
	}
}

class CustomTabComponent extends JPanel {

    JTabbedPane tabbedPane;
    String title;
	JLabel titleLabel;
	JLabel closeLabel;
    public CustomTabComponent(JTabbedPane tabbedPane, String title) {
          this.tabbedPane = tabbedPane;
          this.title = title;
          buildCustomTab();
    }


    private void buildCustomTab() {
		
          setLayout(new BorderLayout());
          titleLabel= new JLabel(title);
		  titleLabel.setSize(30,30);
          titleLabel.setBorder(BorderFactory.createEmptyBorder(7, 7,7,25));
          add(titleLabel, BorderLayout.CENTER);
		  
          closeLabel = new JLabel("X", SwingConstants.CENTER);
          closeLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
          closeLabel.setPreferredSize(new Dimension(25, 10));
		  
          closeLabel.addMouseListener(new MouseAdapter() {
				@Override
                public void mouseClicked(MouseEvent e){
					int a=tabbedPane.indexOfTabComponent(CustomTabComponent.this);
					Editor.list.remove(a);
                    tabbedPane.remove(a);
                }
				@Override
                public void mouseEntered(MouseEvent e){
                      closeLabel.setForeground(Color.RED);
                      closeLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                }
				@Override
                public void mouseExited(MouseEvent e){
                      closeLabel.setForeground(Color.BLACK);
                      closeLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                }
          });
          add(closeLabel, BorderLayout.LINE_END);
    }
}
