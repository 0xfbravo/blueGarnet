package br.com.fpimentel.graf;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.com.fpimentel.util.FuncoesExtras;


public class BotaoSubMenu extends JButton{

	public JPopupMenu popup = new JPopupMenu();
    private static final JButton lafDeterminer = new JButton();
    private static final long serialVersionUID = 1L;
    private boolean rectangularLAF;
    private float alpha = 1f;
    Timer alphaChanger;

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        if (rectangularLAF && isBackgroundSet()) {
            Color c = getBackground();
            g2.setColor(c);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g2);
    }

    @Override
    public void updateUI() {
        super.updateUI();
        lafDeterminer.updateUI();
        rectangularLAF = lafDeterminer.isOpaque();
    }
	public BotaoSubMenu(String nome,String caminhoImagem, Color cor){
		popup.setLabel("Justification");
	    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
	    setForeground(Color.WHITE);
	    setText(nome);
		setToolTipText(nome);
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.BOTTOM);
		setIcon(FuncoesExtras.buscarIcone(caminhoImagem));
		setBorder(new EmptyBorder(15,15,15,15));
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		setBackground(cor);
		setHorizontalAlignment(SwingConstants.LEFT);
		addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setBackground(new Color(123,148,151));
				repaint();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBackground(new Color(28,57,85));
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				setBackground(cor);
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
	}
}
