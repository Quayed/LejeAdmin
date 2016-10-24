package PDFgeneration;
import java.io.File;
import java.io.IOException;
import java.util.List;

import DTO.LejekontraktDTO;
import DTO.LejemålDTO;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class KontraktGenerator
{
    private PDDocument pdfDocument;
    private List<PDField> fields;

    /*public static void main(String[] args)
    {
        FillPDF fillPDF = new FillPDF();
        try {
            fillPDF.run("formular.pdf", "formularFilled.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void run(String inputFileString, String outputFileString, LejekontraktDTO lejekontrakt) throws IOException {
        pdfDocument = PDDocument.load(new File(inputFileString));
        PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();
        LejemålDTO lejemål;

        /*if (lejekontrakt.getLejemål() != null)
            lejemål = lejekontrakt.getLejemål();
        else
            return;
*/
        if (acroForm != null)
        {
            fields = acroForm.getFields();

            //Lejemåls nr.:
            fields.get(94).setValue("");

            // Lejemålet:
            fields.get(1).setValue("Off");  // Lejlighed
            fields.get(54).setValue("Off"); // Enkeltværelse
            fields.get(4).setValue("Off");  // Andelsbolig
            fields.get(11).setValue("Off"); // Fremleje
            fields.get(3).setValue("Off");  // Ejerlejlighed
            fields.get(2).setValue("Off");  // Andet:
            fields.get(93).setValue("");    // Andet: (value)

            /*if (lejemål.getLejemålTypeID() == 1)
                fields.get(1).setValue("On"); // Lejlighed
            else if (lejemål.getLejemålTypeID() == 2)
                fields.get(54).setValue("On"); // Enkeltværelse
            else if (lejemål.getLejemålTypeID() == 3)
                fields.get(4).setValue("On");  // Andelsbolig
            else if (lejemål.getLejemålTypeID() == 4)
                fields.get(11).setValue("On"); // Fremleje
            else if (lejemål.getLejemålTypeID() == 5)
                fields.get(3).setValue("On");  // Ejerlejlighed
            else if (lejemål.getLejemålTypeID() != 0){
                fields.get(2).setValue("On");  // Andet:
                fields.get(93).setValue(lejemål.getLejemålTypeNavn());    // Andet: (value)
            }*/

            fields.get(0).setValue("Holger Danskes Vej 102 st. tv"); // Boligadresse
            fields.get(5).setValue("2000 Frederiksberg");            // Bolig by

            // Udlejeren:
            fields.get(6).setValue("Anders Fredgaard"); // Udlejer
            fields.get(7).setValue("0122334242");       // Udlejer CVR
            fields.get(114).setValue("");               // Udlejer adresse (linje 1)
            fields.get(115).setValue("");               // Udlejer adresse (linje 2)

            // Lejeren:
            fields.get(8).setValue(lejekontrakt.getLejer().getFornavn());     // Lejer (navn)
            fields.get(108).setValue(lejekontrakt.getLejer().getAdresse().getAsString());   // Lejer (adresse) (linje 1)
            fields.get(113).setValue("");   // Lejer (adresse) (linje 2)

            // Areal:
            fields.get(9).setValue("");     // Lejemålets samlede bruttoetageareal
            fields.get(18).setValue("");    // der består af X værelser
            fields.get(10).setValue("");    // Erhvervslokaler m.v. udgør heraf

            // Brugsret til:
            fields.get(12).setValue("Off");      // Fællesvaskeri (Yes/Off)
            fields.get(13).setValue("Off");      // Fælles gårdanlæg
            fields.get(14).setValue("Off");      // Loft-/kælderrum nr.:
            drawText(14, 86, -6, "");            // Loft-/kælderrum nr.: (value)
            fields.get(15).setValue("Off");      // Cykelparkering
            fields.get(16).setValue("Off");      // Garage nr.:
            drawText(16, 50, -6, "");            // Garage nr.: (value)
            fields.get(17).setValue("Off");      // Andet:
            fields.get(117).setValue("");        // Andet: (value)

            // Leje:
            fields.get(100).setValue("");       // Den årlige leje er

            // Betaling:
            fields.get(107).setValue("");       // Lejen m.v. forfalder til betaling den
            fields.get(95).setValue("2");       // i hver (Måned (2) || Kvartal (Choice1))

            // Lejen pr. måned/kvartal udgør:
            fields.get(25).setValue("");

            // Betalinger udover lejen udgør:
            fields.get(26).setValue("");    // A conto varmebidrag
            fields.get(19).setValue("");    // A conto vandbidrag
            fields.get(24).setValue("");    // A conto elbidrag
            fields.get(27).setValue("");    // A conto kølingsbidrag
            fields.get(28).setValue("");    // Antennebidrag
            fields.get(20).setValue("");    // Internetbidrag
            fields.get(21).setValue("");    // Bidrag til beboerrepræsentation
            fields.get(22).setValue("");    // Andet: (0) Value
            fields.get(30).setValue("");    // Andet: (0) Type
            fields.get(23).setValue("");    // Andet: (1) Value
            fields.get(31).setValue("");    // Andet: (1) Type
            fields.get(29).setValue("");    // I alt betales pr. måned/kvartal:

            // Betalingssted:
            fields.get(34).setValue("");    // Udlejerens reg. nr.
            fields.get(32).setValue("");    // Udlejerens kontonr.
            fields.get(33).setValue("");    // Udlejerens pengeinstitut

            // Depositum:
            fields.get(35).setValue("");    // Lejeren betaler et depositum på
            fields.get(37).setValue("");    // Svarende til X måneders leje (højst 3 måneder)

            // Forudbetalt leje:
            fields.get(39).setValue("");    // Svarende til X måneders leje (højst 3 måneder)

            // Indbetaling:
            fields.get(41).setValue("");    // Betaler lejeren i alt X kr.
            fields.get(43).setValue("");    // Forudbetalt leje:
            fields.get(48).setValue("");    // Leje m.v. for perioden: (kr.)
            fields.get(49).setValue("");    // Depositum (første linje) (kr.)
            fields.get(45).setValue("");    // Depositum (anden linje)
            fields.get(50).setValue("");    // Depositum (anden linje) (kr.)
            fields.get(46).setValue("");    // Depositum (tredje linje)
            fields.get(51).setValue("");    // Depositum (tredje linje) (kr.)
            fields.get(47).setValue("");    // Depositum (fjerde linje)
            fields.get(52).setValue("");    // Depositum (fjerde linje) (kr.)
            fields.get(53).setValue("");    // Depositum i alt

            // Første gang, der herefter skal betales husleje, er den:
            fields.get(65).setValue("");

            // Varme:
            fields.get(55).setValue("1");   // Udlejeren leverer varme og varmt vand? (0 || 1)
            fields.get(57).setValue("Off"); // Fjernvarme/Naturgas
            fields.get(58).setValue("Off"); // Centralvarme med olie
            fields.get(59).setValue("Off"); // El til opvarmning
            fields.get(60).setValue("Off"); // Andet:
            fields.get(97).setValue("");    // Andet: (value)
            fields.get(98).setValue("");    // Varmeregnskabsåret begynder den

            fields.get(56).setValue("2");   // Lejeren sørger selv for opvarmning af lejemålet? (Choice1 || 2)    <--- ...fucked
            fields.get(61).setValue("Off"); // Hvis ja, lejemålet opvarmes ved: el
            fields.get(62).setValue("Off"); // Hvis ja, lejemålet opvarmes ved: gas
            fields.get(63).setValue("Off"); // Hvis ja, lejemålet opvarmes ved: olie/petroleum
            fields.get(64).setValue("Off"); // Hvis ja, lejemålet opvarmes ved: fjernvarme/naturgas
            fields.get(78).setValue("Off"); // andet:
            fields.get(109).setValue("");   // andet: (value)

            // Vand:
            fields.get(66).setValue("2"); // Udlejeren leverer vand til lejemålet? (Choice1 || 2)
            fields.get(67).setValue("2"); // Hvis ja, udgiften til vand fordeles på grundlag af individuelle forbrugsmålere?
            fields.get(110).setValue(""); // Vandregnskabsåret begynder den

            // El:
            fields.get(68).setValue("2"); // Udlejeren leverer el til andet end varme til lejemålet?
            fields.get(111).setValue(""); // Elregnskabsåret begynder den

            // Køling:
            fields.get(69).setValue("2"); // Udlejeren leverer køling til lejemålet?
            fields.get(70).setValue("2"); // Hvis ja, udgiften til køling fordeles på grundlag af individuelle forbrugsmålere?
            fields.get(112).setValue(""); // Kølingsregnskabsåret begynder den

            // Fællesantenne:
            fields.get(71).setValue("2"); // Udlejeren leverer fælles signalforsyning, hvor til lejer skal betale bidrag
            fields.get(72).setValue("2"); // Lejernes antenneforening i ejendommen leverer fælles signalforsyning
            fields.get(73).setValue("2"); // Udlejeren leverer adgang til internet, (elektroniske kommunikationstjenester) hvortil lejeren skal betale bidrag

            // Lejemålets stand ved indflytning
            fields.get(74).setValue("2"); // Er/bliver lejemålets stand konstateret ved et indflytningssyn?

            // Vedligeholdelse
            fields.get(76).setValue("Choice1"); // Den indvendige vedligeholdelse af lejemålet påhviler: (Udlejeren (Choice1) || Lejeren (2))

            // Inventar
            fields.get(79).setValue("Off");     // Komfur
            fields.get(80).setValue("Off");     // Opvaskemaskine
            fields.get(81).setValue("Off");     // Emhætte
            fields.get(82).setValue("Off");     // Andet: (første linje)
            fields.get(99).setValue("");        // Andet: (første linje) (value)
            fields.get(83).setValue("Off");     // Køleskab
            fields.get(84).setValue("Off");     // Vaskemaskine
            fields.get(85).setValue("Off");     // Elpaneler, antal:
            drawText(85, 69, -6,"");            // Elpaneler, antal: (value)
            fields.get(86).setValue("Off");     // Andet: (anden linje)
            fields.get(75).setValue("");        // Andet: (anden linje) (value)
            fields.get(87).setValue("Off");     // Fryser
            fields.get(88).setValue("Off");     // Tørretumbler
            fields.get(89).setValue("Off");     // Vandvarmere, antal:
            drawText(89, 84, -6,"");            // Vandvarmere, antal: (value)
            fields.get(90).setValue("Off");     // Andet: (tredje linje)
            fields.get(101).setValue("");       // Andet: (tredje linje) (value)

            // Beboerrepræsentation:
            fields.get(77).setValue("0");       // Der er ved kontraktens oprettelse etableret beboerrepræsentation i ejendommen?

            // Husdyr:
            fields.get(91).setValue("2");       // Det er tilladt at holde husdyr i lejemålet?

            // Husorden:
            fields.get(92).setValue("2");       // Der foreligger ved lejeforholdets indgåelse en husorden for ejendommen?

            // Øvrige oplysninger om det lejede:
            fields.get(104).setValue("");

            // Særlige vilkår
            fields.get(105).setValue("");       // Side 4
            fields.get(106).setValue("");       // Side 5

            // Underskrift
            fields.get(102).setValue("");       // Dato: (udlejer)
            drawSignature("", true);            // Underskrift (udlejer)
            fields.get(103).setValue("");       // Dato: (lejer)
            drawSignature("", false);           // Underskift (lejer)

            // Unknown fields:
            fields.get(36).setValue("");
            fields.get(38).setValue("");
            fields.get(40).setValue("");
            fields.get(96).setValue("Choice1");
            fields.get(116).setValue("");
            fields.get(118).setValue("");
            fields.get(120).setValue("");
        }
        pdfDocument.save(outputFileString);
        pdfDocument.close();
    }

    private void drawSignature(String txt, boolean udlejer) throws IOException {
        if (udlejer)
            drawText(102, -140, -60, txt);
        else
            drawText(103, -140, -60, txt);
    }

    private void drawText(int fieldNr, int offsetX, int offsetY, String txt) throws IOException {
        PDFont font = PDType1Font.HELVETICA;
        PDPage page = null;
        PDRectangle fieldArea = getFieldArea(fields.get(fieldNr));

        for (PDAnnotationWidget widget : fields.get(fieldNr).getWidgets()) {
            if (widget != null && widget.getPage() != null) {
                page = widget.getPage();
                break;
            }
        }

        if (page != null) {
            PDPageContentStream content = new PDPageContentStream(pdfDocument,
                    page,
                    PDPageContentStream.AppendMode.APPEND,
                    true);

            content.setNonStrokingColor(0, 0, 0); //black text
            content.beginText();
            content.setFont(font, 9);
            content.newLineAtOffset(fieldArea.getUpperRightX() + offsetX,
                    fieldArea.getUpperRightY() + offsetY);
            content.showText(txt);
            content.endText();
            content.close();
        }
    }

    private PDRectangle getFieldArea(PDField field) {
        COSDictionary fieldDict = field.getCOSObject();
        COSArray fieldAreaArray = (COSArray) fieldDict.getDictionaryObject(COSName.RECT);
        return new PDRectangle(fieldAreaArray);
    }

    private String booleanToOnOff(boolean boolConvert){
        if(boolConvert)
            return "On";
        else
            return "Off";
    }
}