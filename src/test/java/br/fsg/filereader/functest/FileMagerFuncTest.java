package br.fsg.filereader.functest;

import br.fsg.filereader.controller.DirectoryController;
import br.fsg.filereader.controller.ProductController;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Test;

public class FileMagerFuncTest {

    DirectoryController directoryController = new DirectoryController();
    ProductController productController = new ProductController();

    @After
    public void finish() {
        productController.deleteAll();
        directoryController.deleteAll();
    }

    @Test
    public void funcionalTest() {
        directoryController = new DirectoryController();
        directoryController.salvar(Paths.get("D:\\Teste\\drive"), "colar", "R$ 12,00");

        productController = new ProductController();
        productController.save(Paths.get("D:\\Teste\\local\\R$ 12,00"), Paths.get("D:\\Teste\\drive\\R$ 12,00"));
    }

}
