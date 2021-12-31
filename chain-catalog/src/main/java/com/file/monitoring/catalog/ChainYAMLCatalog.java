package com.file.monitoring.catalog;

import com.file.monitoring.catalog.beans.CatalogBean;
import com.file.monitoring.catalog.beans.ChainConfig;
import org.apache.commons.chain.Catalog;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.impl.CatalogBase;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Component
public class ChainYAMLCatalog {

    @Autowired
    private BeanFactory beanFactory;

    @Value("${chain.config.yml.path}")
    String chainConfigXMLPath;

    @Bean("ChainYMLCatalog")
    private Catalog parseConfigFile() {
        System.out.println(chainConfigXMLPath);
        Yaml yaml = new Yaml(new Constructor(CatalogBean.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(chainConfigXMLPath);
        CatalogBean catalogBean = yaml.load(inputStream);

        System.out.println(catalogBean);

        CatalogBase catalogBase = new CatalogBase();

        for (ChainConfig cc : catalogBean.getCatalog()) {
            ChainBase chainBase = new ChainBase();

            for (String commandName : cc.getCommands()) {
                if(StringUtils.isNotBlank(commandName)) {
                    chainBase.addCommand(beanFactory.getBean(commandName, Command.class));
                }
            }
            if(StringUtils.isNotBlank(cc.getChain())) {
                catalogBase.addCommand(cc.getChain(), chainBase);
            }
        }

        return catalogBase;
    }
}



