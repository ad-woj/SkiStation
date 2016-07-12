/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Bluu
 */
public class PDFCreator {
    
    public void create(String[][] content) throws IOException{
    PDDocument doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage( page );
    PDPageContentStream contentStream = new PDPageContentStream(doc, page);

    drawTable(page, contentStream, 700, 100, content);

    contentStream.close();
    doc.save("ClientCard.pdf" );
    doc.close();
} 

    private void drawTable(PDPage page, PDPageContentStream contentStream,
                             float y, float margin,
                             String[][] content) throws IOException {
         final int rows = content.length;
        final int cols = content[0].length;
        final float rowHeight = 20f;
        final float tableWidth = page.getCropBox().getWidth() - margin - margin;
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth/(float)cols;
        final float cellMargin=5f;

        float nexty = y ;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin+tableWidth, nexty);
            nexty-= rowHeight;
        }

        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y-tableHeight);
            nextx += colWidth;
        }

        contentStream.setFont( PDType1Font.HELVETICA_BOLD , 12 );

        contentStream.beginText();
        contentStream.moveTextPositionByAmount(margin,y + 10);
        contentStream.drawString("Ski Station Card");
        contentStream.endText();
        
        float textx = margin+cellMargin;
        float texty = y-15;
        for(int i = 0; i < content.length; i++){
            for(int j = 0 ; j < content[i].length; j++){
                String text = content[i][j];
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx,texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty-=rowHeight;
            textx = margin+cellMargin;
        }
    }
    
}
