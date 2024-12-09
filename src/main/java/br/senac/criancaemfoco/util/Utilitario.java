package br.senac.criancaemfoco.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utilitario {

	public static byte[] converterImagemParaFormato(byte[] imagemOriginal, String formato) throws IOException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(imagemOriginal);
		BufferedImage imagem = ImageIO.read(inputStream);

		if (imagem == null) {
			throw new IOException("A imagem enviada não é válida ou está corrompida.");
		}

		BufferedImage imagemConvertida = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = imagemConvertida.createGraphics();
		g2d.drawImage(imagem, 0, 0, null);
		g2d.dispose();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(imagemConvertida, formato, outputStream);

		return outputStream.toByteArray();
	}

}
