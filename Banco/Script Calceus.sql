-- MySQL Script generated by MySQL Workbench
-- 07/30/15 02:06:35
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema calceus
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `calceus` ;

-- -----------------------------------------------------
-- Schema calceus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `calceus` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `calceus` ;

-- -----------------------------------------------------
-- Table `calceus`.`Endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Endereco` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `cep` INT(8) NOT NULL,
  `logradouro` VARCHAR(50) NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `logradouro_UNIQUE` ON `calceus`.`Endereco` (`logradouro` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Pessoa` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `cpf` INT NOT NULL,
  `idade` INT(3) NULL,
  `sexo` CHAR(1) NULL,
  `nome` VARCHAR(60) NULL,
  `rg` VARCHAR(12) NULL,
  `email` VARCHAR(25) NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `cpf_UNIQUE` ON `calceus`.`Pessoa` (`cpf` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`telefone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`telefone` ;

CREATE TABLE IF NOT EXISTS `calceus`.`telefone` (
  `idtelefone` INT NOT NULL AUTO_INCREMENT,
  `ddd` INT(3) NOT NULL,
  `telefone` INT(9) NOT NULL,
  `tipoTelefone` VARCHAR(10) NULL,
  `Pessoa_idPessoa` INT NULL,
  PRIMARY KEY (`idtelefone`),
  CONSTRAINT `fk_telefone_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `calceus`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_telefone_Pessoa1_idx` ON `calceus`.`telefone` (`Pessoa_idPessoa` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `tipoCliente` VARCHAR(45) NOT NULL,
  `status` CHAR NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idCliente`, `Pessoa_idPessoa`),
  CONSTRAINT `fk_Cliente_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `calceus`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cliente_Pessoa1_idx` ON `calceus`.`Cliente` (`Pessoa_idPessoa` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Cargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Cargo` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Cargo` (
  `idCargo` INT NOT NULL AUTO_INCREMENT,
  `nomeCargo` VARCHAR(45) NOT NULL,
  `obs` VARCHAR(100) NULL,
  PRIMARY KEY (`idCargo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `calceus`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Funcionario` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nomeFuncionario` VARCHAR(60) NOT NULL,
  `dataAdmissao` VARCHAR(45) NULL,
  `carteiraTrabalho` INT NULL,
  `serie` VARCHAR(5) NULL,
  `numPIS` VARCHAR(45) NULL,
  `salario` DOUBLE NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  `Cargo_idCargo` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`, `Pessoa_idPessoa`, `Cargo_idCargo`),
  CONSTRAINT `fk_Funcionario_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `calceus`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Cargo1`
    FOREIGN KEY (`Cargo_idCargo`)
    REFERENCES `calceus`.`Cargo` (`idCargo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Funcionario_Pessoa1_idx` ON `calceus`.`Funcionario` (`Pessoa_idPessoa` ASC);

CREATE INDEX `fk_Funcionario_Cargo1_idx` ON `calceus`.`Funcionario` (`Cargo_idCargo` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Fornecedor` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Fornecedor` (
  `idFornecedor` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(18) NOT NULL,
  `nomeFornecedor` VARCHAR(50) NOT NULL,
  `site` VARCHAR(45) NULL,
  `obs` VARCHAR(100) NULL,
  PRIMARY KEY (`idFornecedor`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `cnpj_UNIQUE` ON `calceus`.`Fornecedor` (`cnpj` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Endereco_Entidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Endereco_Entidade` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Endereco_Entidade` (
  `idEndereco_Entidade` INT NOT NULL AUTO_INCREMENT,
  `Pessoa_idPessoa` INT NULL,
  `Endereco_idEndereco` INT NULL,
  `Fornecedor_idFornecedor` INT NULL,
  PRIMARY KEY (`idEndereco_Entidade`),
  CONSTRAINT `fk_Endereco_Entidade_Pessoa`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `calceus`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Endereco_Entidade_Endereco1`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `calceus`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Endereco_Entidade_Fornecedor1`
    FOREIGN KEY (`Fornecedor_idFornecedor`)
    REFERENCES `calceus`.`Fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Endereco_Entidade_Pessoa_idx` ON `calceus`.`Endereco_Entidade` (`Pessoa_idPessoa` ASC);

CREATE INDEX `fk_Endereco_Entidade_Endereco1_idx` ON `calceus`.`Endereco_Entidade` (`Endereco_idEndereco` ASC);

CREATE INDEX `fk_Endereco_Entidade_Fornecedor1_idx` ON `calceus`.`Endereco_Entidade` (`Fornecedor_idFornecedor` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`FormaPagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`FormaPagamento` ;

CREATE TABLE IF NOT EXISTS `calceus`.`FormaPagamento` (
  `idFormaPagamento` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `prazo` VARCHAR(1) NOT NULL,
  `desconto` DECIMAL(2,1) NOT NULL,
  `situacao` VARCHAR(1) NULL,
  PRIMARY KEY (`idFormaPagamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `calceus`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `dataPedido` DATETIME NOT NULL,
  `valorTotal` DECIMAL(7,2) NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idPedido`, `Cliente_idCliente`),
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `calceus`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pedido_Cliente1_idx` ON `calceus`.`Pedido` (`Cliente_idCliente` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Pagamento` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Pagamento` (
  `idPagamento` INT NOT NULL AUTO_INCREMENT,
  `FormaPagamento_idFormaPagamento` INT NOT NULL,
  `Pedido_idPedido` INT NOT NULL,
  `vencimento` DATETIME NOT NULL,
  `status` VARCHAR(1) NULL,
  PRIMARY KEY (`idPagamento`, `FormaPagamento_idFormaPagamento`, `Pedido_idPedido`),
  CONSTRAINT `fk_Pagamento_FormaPagamento1`
    FOREIGN KEY (`FormaPagamento_idFormaPagamento`)
    REFERENCES `calceus`.`FormaPagamento` (`idFormaPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pagamento_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `calceus`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pagamento_FormaPagamento1_idx` ON `calceus`.`Pagamento` (`FormaPagamento_idFormaPagamento` ASC);

CREATE INDEX `fk_Pagamento_Pedido1_idx` ON `calceus`.`Pagamento` (`Pedido_idPedido` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(100) NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `categoria_UNIQUE` ON `calceus`.`Categoria` (`categoria` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`Produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Produto` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nomeProduto` VARCHAR(45) NULL,
  `Fornecedor_idFornecedor` INT NOT NULL,
  `quantidade` INT NOT NULL DEFAULT 0,
  `valor` DECIMAL(7,2) NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProduto`, `Fornecedor_idFornecedor`, `Categoria_idCategoria`),
  CONSTRAINT `fk_Produto_Fornecedor1`
    FOREIGN KEY (`Fornecedor_idFornecedor`)
    REFERENCES `calceus`.`Fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `calceus`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Produto_Fornecedor1_idx` ON `calceus`.`Produto` (`Fornecedor_idFornecedor` ASC);

CREATE INDEX `fk_Produto_Categoria1_idx` ON `calceus`.`Produto` (`Categoria_idCategoria` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`ItemPedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`ItemPedido` ;

CREATE TABLE IF NOT EXISTS `calceus`.`ItemPedido` (
  `idItemPedido` INT NOT NULL AUTO_INCREMENT,
  `Produto_idProduto` INT NOT NULL,
  `Pedido_idPedido` INT NOT NULL,
  `Pedido_Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idItemPedido`, `Produto_idProduto`, `Pedido_idPedido`, `Pedido_Cliente_idCliente`),
  CONSTRAINT `fk_ItemPedido_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `calceus`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemPedido_Pedido1`
    FOREIGN KEY (`Pedido_idPedido` , `Pedido_Cliente_idCliente`)
    REFERENCES `calceus`.`Pedido` (`idPedido` , `Cliente_idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_ItemPedido_Produto1_idx` ON `calceus`.`ItemPedido` (`Produto_idProduto` ASC);

CREATE INDEX `fk_ItemPedido_Pedido1_idx` ON `calceus`.`ItemPedido` (`Pedido_idPedido` ASC, `Pedido_Cliente_idCliente` ASC);


-- -----------------------------------------------------
-- Table `calceus`.`TipoMovimentacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`TipoMovimentacao` ;

CREATE TABLE IF NOT EXISTS `calceus`.`TipoMovimentacao` (
  `idTipoMovimentacao` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoMovimentacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `calceus`.`Estoque`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `calceus`.`Estoque` ;

CREATE TABLE IF NOT EXISTS `calceus`.`Estoque` (
  `idEstoque` INT NOT NULL AUTO_INCREMENT,
  `dataMovimentacao` DATETIME NOT NULL,
  `TipoMovimentacao_idTipoMovimentacao` INT NOT NULL,
  `Pedido_idPedido` INT NOT NULL,
  PRIMARY KEY (`idEstoque`, `TipoMovimentacao_idTipoMovimentacao`, `Pedido_idPedido`),
  CONSTRAINT `fk_Estoque_TipoMovimentacao1`
    FOREIGN KEY (`TipoMovimentacao_idTipoMovimentacao`)
    REFERENCES `calceus`.`TipoMovimentacao` (`idTipoMovimentacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estoque_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `calceus`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Estoque_TipoMovimentacao1_idx` ON `calceus`.`Estoque` (`TipoMovimentacao_idTipoMovimentacao` ASC);

CREATE INDEX `fk_Estoque_Pedido1_idx` ON `calceus`.`Estoque` (`Pedido_idPedido` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `calceus`.`Cargo`
-- -----------------------------------------------------
START TRANSACTION;
USE `calceus`;
INSERT INTO `calceus`.`Cargo` (`idCargo`, `nomeCargo`, `obs`) VALUES (1, 'CEO', 'Manda na Bagaça');
INSERT INTO `calceus`.`Cargo` (`idCargo`, `nomeCargo`, `obs`) VALUES (2, 'Diretor', 'Quase manda');
INSERT INTO `calceus`.`Cargo` (`idCargo`, `nomeCargo`, `obs`) VALUES (3, 'Gerente', 'É pau mandado');
INSERT INTO `calceus`.`Cargo` (`idCargo`, `nomeCargo`, `obs`) VALUES (4, 'Vendedor', 'Só se lasca');

COMMIT;

