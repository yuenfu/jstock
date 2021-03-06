/*
 * JStock - Free Stock Market Software
 * Copyright (C) 2009 Yan Cheng Cheok <yccheok@yahoo.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.yccheok.jstock.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.l2fprod.common.swing.*;
import org.yccheok.jstock.internationalization.GUIBundle;

/**
 *
 * @author  yccheok
 */
public class OptionsJPanel extends javax.swing.JPanel implements JStockOptionsObserver {
    
    /** Creates new form OptionsJPanel */
    public OptionsJPanel() {
        initComponents();
        
        initOptionsJPanels();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonBar1 = new JButtonBar(JButtonBar.VERTICAL);

        setLayout(new java.awt.BorderLayout());

        add(jButtonBar1, java.awt.BorderLayout.WEST);

    }// </editor-fold>//GEN-END:initComponents
    
    private void addButton(String title, String iconUrl, final Component component, JButtonBar bar, ButtonGroup group) {
        Action action = new AbstractAction( title, new ImageIcon(OptionsJPanel.class.getResource(iconUrl))) {
            @Override
            public void actionPerformed(ActionEvent e) {
                show(component);
            }
        };

        JToggleButton button = new JToggleButton(action); 
        
        // Specify text position to overcome display issue in all L&F.
        button.setVerticalTextPosition(AbstractButton.BOTTOM);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
    
        bar.add(button);

        map.put(title, button);
        
        group.add(button);

        if (group.getSelection() == null) {
            button.setSelected(true);
            show(component);
        }
    }    
    
    private void show(Component component) {
        if (currentComponent != null) {
            remove(currentComponent);
        }
        
        add("Center", currentComponent = component);
        revalidate();
        repaint();
    }
    
    private void initOptionsJPanels() {
        optionsAlertJPanel = new OptionsAlertJPanel();
        optionsIndicatorJPanel = new OptionsIndicatorJPanel();
        optionsNetworkJPanel = new OptionsNetworkJPanel();
        optionsSpeedJPanel = new OptionsSpeedJPanel();
        optionsColorJPanel = new OptionsColorJPanel();
        optionsBrokerJPanel = new OptionsBrokerJPanel();
        optionsSellAdvisorJPanel = new OptionsSellAdvisorJPanel();
        optionsGUIJPanel = new OptionGUIJPanel();
        optionsUpdateJPanel = new OptionsUpdateJPanel();

        // The size of OptionsJPanel, will be determined by the first added panel.
        addButton(GUIBundle.getString("OptionsJPanel_Broker"), "/images/32x32/calc.png", optionsBrokerJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_Wealth"), "/images/32x32/money3.png", optionsSellAdvisorJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_Alert"), "/images/32x32/bell.png", optionsAlertJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_GUI"), "/images/32x32/kchart.png", optionsGUIJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_Speed"), "/images/32x32/clock.png", optionsSpeedJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_Color"), "/images/32x32/colors.png", optionsColorJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_Network"), "/images/32x32/connect_to_network.png", optionsNetworkJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_Indicator"), "/images/32x32/find.png", optionsIndicatorJPanel, jButtonBar1, buttonGroup1);
        addButton(GUIBundle.getString("OptionsJPanel_Update"), "/images/32x32/epiphany-download.png", optionsUpdateJPanel, jButtonBar1, buttonGroup1);
    }

    @Override
    public void set(JStockOptions jStockOptions) {
        optionsBrokerJPanel.set(jStockOptions);
        optionsColorJPanel.set(jStockOptions);
        optionsAlertJPanel.set(jStockOptions);
        optionsNetworkJPanel.set(jStockOptions);
        optionsIndicatorJPanel.set(jStockOptions);
        optionsSpeedJPanel.set(jStockOptions);       
        optionsSellAdvisorJPanel.set(jStockOptions);
        optionsGUIJPanel.set(jStockOptions);
        optionsUpdateJPanel.set(jStockOptions);
    }

    public void cancel() {
        optionsNetworkJPanel.cancel();
        optionsAlertJPanel.cancel();
        optionsUpdateJPanel.cancel();
    }

    @Override
    public boolean apply(JStockOptions jStockOptions) {
        /* FIXME : We should make use of JStockOptionsObserver interface. */
        if (optionsBrokerJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Broker"));
            
            button.setSelected(true);
            button.doClick();
            return false;
        }

        if (optionsGUIJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_GUI"));

            button.setSelected(true);
            button.doClick();
            return false;
        }

        if (optionsColorJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Color"));
            
            button.setSelected(true);
            button.doClick();
            return false;
        }
        
        if (optionsAlertJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Alert"));
            
            button.setSelected(true);
            button.doClick();
            return false;
        }

        if (optionsIndicatorJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Indicator"));
            
            button.setSelected(true);
            button.doClick();
            return false;
        }
        
        if (optionsNetworkJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Network"));
            
            button.setSelected(true);
            button.doClick();
            return false;
        }
        
        if (optionsSpeedJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Speed"));
            
            button.setSelected(true);
            button.doClick();
            return false;
        }
        
        if (optionsSellAdvisorJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Wealth"));
            
            button.setSelected(true);
            button.doClick();
            return false;
        }

        if(optionsUpdateJPanel.apply(jStockOptions) == false)
        {
            final JToggleButton button = map.get(GUIBundle.getString("OptionsJPanel_Update"));

            button.setSelected(true);
            button.doClick();
            return false;
        }
        
        return true;
    }

    /**
     * Selects the desired options page.
     *
     * @param buttonMapKey title of the page
     */
    public void select(String buttonMapKey) {
        final JToggleButton button = map.get(buttonMapKey);
        if (button == null) {
            // Avoid null pointer.
            return;
        }
        button.setSelected(true);
        button.doClick();
    }

    private Component currentComponent;
    private OptionsAlertJPanel optionsAlertJPanel;
    private OptionsNetworkJPanel optionsNetworkJPanel;
    private OptionsIndicatorJPanel optionsIndicatorJPanel;
    private OptionsSpeedJPanel optionsSpeedJPanel;
    private OptionsColorJPanel optionsColorJPanel;
    private OptionsBrokerJPanel optionsBrokerJPanel;
    private OptionsSellAdvisorJPanel optionsSellAdvisorJPanel;
    private OptionGUIJPanel optionsGUIJPanel;
    private OptionsUpdateJPanel optionsUpdateJPanel;

    private java.util.Map<String, JToggleButton> map = new java.util.HashMap<String, JToggleButton>();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.l2fprod.common.swing.JButtonBar jButtonBar1;
    // End of variables declaration//GEN-END:variables
    
}
