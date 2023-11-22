package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.notacorretagems;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.UsuarioService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/notacorretagems")
public class NotacorretagemController {

    @Autowired
    private NotacorretagemService service;

    @Autowired
    private UsuarioService user;

    @GetMapping
//    @ApiOperation(value = "Retorna todos os produtos cadastrados.")
    public ResponseEntity<List<NotacorretagemDTO>> selectAll() {
        List<NotacorretagemDTO> notacorretagems = service.getNotaCorretagem();
        return ResponseEntity.ok(notacorretagems);
    }

    @GetMapping("/lenota")
    public void leNota() {

        PDDocument document = null;
        try {
            document = PDDocument.load(new File("C:/Users/lemos/OneDrive/Área de Trabalho/nota.pdf"));

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile  file) {

        File filePDF = convertMultipartFileToFile(file);
        PDDocument document = null;

        try {
            document = PDDocument.load(filePDF);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println(text);
            service.getData(text);

//            Set<Ativo> ativos = new HashSet<>();
//            service.saveNotaCorretagem(new Notacorretagem(
//                5050L,
//                "NotaTeste",
//                    new Timestamp(timestampMillis),
//                2150.0,
//                5160.0,
//                0.58,
//                0.09,
//                            1.0,
//                "D",
//                0.0,
//                    UsuarioDTO.converterDtoParaObjeto(user.getUsuarioByID(1)),
//                    ativos
//            ));

            return ResponseEntity.ok("Arquivo enviado !");
        }catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok("Erro ao subir arquivo !");
        }finally{
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static File convertMultipartFileToFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}


