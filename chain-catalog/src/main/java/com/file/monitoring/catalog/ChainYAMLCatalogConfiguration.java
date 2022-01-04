package com.file.monitoring.catalog;

import com.file.monitoring.catalog.beans.CatalogBean;
import com.file.monitoring.catalog.beans.ChainConfig;

import com.file.monitoring.common.configs.Catalog;
import com.file.monitoring.common.configs.Chain;
import com.file.monitoring.common.configs.Command;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class ChainYAMLCatalogConfiguration {

    @Autowired
    private BeanFactory beanFactory;

    @Value("${chain.config.yml.path}")
    String chainConfigYMLPath;

    @Bean("ChainCatalog")
    private Catalog parseConfigFile() throws Exception {
        Yaml yaml = new Yaml(new Constructor(CatalogBean.class));
        CatalogBean catalogBean = yaml.load(getValidChainConfigs());

        Catalog catalog = new Catalog();

        for (ChainConfig cc : catalogBean.getCatalog()) {
            if (StringUtils.isBlank(cc.getChain())) {
                break;
            }
            Chain chain = new Chain(cc.getChain());
            catalog.addChain(chain);

            for (String commandName : cc.getCommands()) {
                if (StringUtils.isNotBlank(commandName)) {
                    chain.addCommand(beanFactory.getBean(commandName, Command.class));
                }
            }

        }

        return catalog;
    }

    private InputStream getValidChainConfigs() throws Exception {
        File yamlFile = new File(chainConfigYMLPath);
        if (yamlFile.isFile() && yamlFile.canRead()) {
            return new FileInputStream(yamlFile);
        }
        return this.getClass()
                .getClassLoader()
                .getResourceAsStream(chainConfigYMLPath);
    }
}



