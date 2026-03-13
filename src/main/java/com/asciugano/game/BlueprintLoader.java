package com.asciugano.game;

import com.asciugano.engine.entities.Blueprint;
import com.asciugano.engine.entities.ComponentBlueprint;
import com.asciugano.engine.entities.MeshComponent;
import com.asciugano.engine.models.RawModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlueprintLoader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Blueprint load(File file) throws IOException {
        JsonNode root = mapper.readTree(file);
        List<MeshComponent> componentBlueprints = new ArrayList<>();
        Iterator<String> filedNames = root.fieldNames();
        boolean save = false;
        while (filedNames.hasNext()) {
            String sectionName = filedNames.next();
            JsonNode section = root.get(sectionName);

            switch(sectionName) {
                case "STANDARD" -> save = section.get("save").asBoolean();
                case "RENDER" -> {
                    List<RawModel> meshes = mapper.convertValue(section.get("meshes"), new TypeReference<List<RawModel>>() { });
                    componentBlueprints.add(new MeshComponent());
                }
            }
        }
        return new Blueprint(file.getName(), save, componentBlueprints.toArray(new ComponentBlueprint[0]));
    }
}
