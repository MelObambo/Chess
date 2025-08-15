package graphics;

import objects.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class PieceButton extends JButton implements ActionListener {
    private String position;
    private Piece piece;

    protected void setPiece(Piece piece) {
        this.piece = piece;
        this.updateIcon();
    }

    protected Piece getPiece() {
        return this.piece;
    }

    public String getPosition(){
        return this.position;
    }

    private void updateIcon() {
        if (this.piece == null)
            setIcon(null);
        else {
            URL imgUrl = getClass().getResource("/resources/" + this.piece.getClass().getSimpleName().toLowerCase() + ".png");
            ImageIcon icon = new ImageIcon(imgUrl);
            Image image = icon.getImage();
            Image resizedIcon = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(resizedIcon));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.piece.getClass().getSimpleName().toLowerCase());

    }

    public PieceButton(String position) {
        this.addActionListener(this);
    }
}
