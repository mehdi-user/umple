/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.samples.svg.gui;
import java.awt.*;
import java.net.*;
import org.jhotdraw.draw.*;

public class DrawingOpacityIcon
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DrawingOpacityIcon()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private DrawingEditor editor;
private AttributeKey<Double> opacityKey;
private AttributeKey<Color> fillColorKey;
private AttributeKey<Color> strokeColorKey;
private Shape fillShape;
private Shape strokeShape;
@Override
    public void paintIcon(java.awt.Component c, java.awt.Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        super.paintIcon(c, g, x, y);
        Double opacity=0d;
        Color fillColor=null;
        Color strokeColor=null;
        if (editor != null) {
            DrawingView view = editor.getActiveView();
            if (view != null && view.getDrawing() != null) {
                Drawing d = view.getDrawing();
                opacity = d.get(opacityKey);
                fillColor = (fillColorKey == null) ? null : d.get(fillColorKey);
                strokeColor = (strokeColorKey == null) ? null : d.get(strokeColorKey);
            } else {
                opacity = opacityKey.get(editor.getDefaultAttributes());
                fillColor = (fillColorKey == null) ? null : fillColorKey.get(editor.getDefaultAttributes());
                strokeColor = (strokeColorKey == null) ? null : strokeColorKey.get(editor.getDefaultAttributes());
            }
        }

        if (fillColorKey != null && fillShape != null) {
            if (opacity != null) {
                if (fillColor == null) {
                    fillColor = Color.BLACK;
                }
                g.setColor(new Color((((int) (opacity * 255)) << 24) | (fillColor.getRGB() & 0xffffff), true));
                g.translate(x, y);
                g.fill(fillShape);
                g.translate(-x, -y);
            }
        }
        if (strokeColorKey != null && strokeShape != null) {
            if (opacity != null) {
                if (strokeColor == null) {
                    strokeColor = Color.BLACK;
                }
                g.setColor(new Color((((int) (opacity * 255)) << 24) | (strokeColor.getRGB() & 0xffffff), true));
                g.translate(x, y);
                g.draw(strokeShape);
                g.translate(-x, -y);
            }
        }
    }
}