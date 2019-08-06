package com.example.demo.controller;


import com.example.demo.entity.Kniga;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller {

        @Autowired
        private final com.example.demo.service.KnigaService knigaService;




        //Достать юзера по ID
        @GetMapping("/kniga/{knigaId}")
        public ResponseEntity<Kniga> getUserById(@PathVariable("knigaId") Long knigaId) throws SQLException {

                return ResponseEntity.ok(knigaService.getById(knigaId));
        }

        //Достать всех юзеров
        @GetMapping("/kniga/List")
        public ResponseEntity<List<Kniga>> getAllUsers() throws SQLException {
                return ResponseEntity.ok(knigaService.getAll());
        }
        //Удалить юзера по ID
        @DeleteMapping("/kniga/{knigaId}")
        public ResponseEntity<Long> deletetUserById(@PathVariable("knigaId") Long knigaId) throws SQLException {

                return ResponseEntity.ok(knigaService.remove(knigaId));

        }
        //Добавить
        @PostMapping("/kniga/create")
        public ResponseEntity<Integer> save(@RequestBody Kniga kniga) {
                try {
                        return ResponseEntity.ok(knigaService.add(kniga));
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return null;
        }
        //Изменить
        @PutMapping("/kniga/update")
        public ResponseEntity<Integer> update(@RequestBody Kniga kniga) {
                try {
                        return ResponseEntity.ok(knigaService.update(kniga));
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return null;
        }

        //Прочитать файл
        @PostMapping("/kniga/xml/file")
        public ResponseEntity<Long> readFile(@RequestParam MultipartFile xml) throws IOException {
                return ResponseEntity.ok(knigaService.readFile(xml.getBytes()));
        }

        //Создание файла
        @GetMapping (value = "/kniga/xml/file/download", produces = MediaType.APPLICATION_XML_VALUE)
        public ResponseEntity<byte[]> fileForBD() throws IOException, SQLException {
            return ResponseEntity.ok(knigaService.fileForBD());

        }





}