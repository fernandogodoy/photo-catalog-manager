package br.fsg.filereader.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author user
 */
public class JDesktopPaneBackground extends JDesktopPane {

	private static final long serialVersionUID = 1L;
	private String caminho;

	public JDesktopPaneBackground(String caminho) {
		this.caminho = caminho;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (StringUtils.isNotBlank(caminho)) {
			Image imagem = Toolkit.getDefaultToolkit().getImage(caminho);
			g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
}
