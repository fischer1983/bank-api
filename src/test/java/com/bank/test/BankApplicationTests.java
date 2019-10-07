package com.bank.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.facade.OpenContaFacadeImpl;
import com.bank.model.Conta;
import com.bank.model.Pessoa;
import com.bank.model.TipoPessoa;
import com.bank.service.ContaServiceImpl;
import com.bank.service.PessoaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankApplicationTests {

	private final BigDecimal LIMITE_CHEQUE_ESPECIAL_SCORE_2_AND_5 = new BigDecimal("1000.00");
	private final BigDecimal LIMITE_CARTAO_SCORE_2_AND_5 = new BigDecimal("200.00");
	
	private final BigDecimal LIMITE_CARTAO_SCORE_6_AND_8 = new BigDecimal("2000.00");
	private final BigDecimal LIMITE_CARTAO_SCORE_9 = new BigDecimal("15000.00");
	
	private final BigDecimal LIMITE_CHEQUE_ESPECIAL_SCORE_6_AND_8 = new BigDecimal("2000.00");
	private final BigDecimal LIMITE_CHEQUE_ESPECIAL_SCORE_9 = new BigDecimal("5000.00");

	private Pessoa pessoaPfScore0And1;
	
	private Pessoa pessoaPjScore2And5;
	
	private Pessoa pessoaPfScore6And8;
	
	private Pessoa pessoaPjScore9;
	
	@Autowired
	private ContaServiceImpl contaService;
	
	@Autowired 
	private PessoaServiceImpl pessoaService;
	
	@Autowired
	private OpenContaFacadeImpl openContaFacade;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
	@Before
	public void beforeTest() throws Exception {
		
		pessoaPfScore0And1 = pessoaService.buildPessoa("07602106083", 1);
		
		pessoaPjScore2And5 = pessoaService.buildPessoa("69496952000144", 4);
		
		pessoaPfScore6And8 = pessoaService.buildPessoa("59569212004", 8);
		
		pessoaPjScore9 = pessoaService.buildPessoa("39570143000174", 9);
	}

	/*
	 * 6 digitos gerados unicos e gerados automaticamente
	 */
	@Test
	public void generateNumeroContaTest() {
		
		final String numeroConta = contaService.generateNumeroConta();
		
		assertEquals(6, numeroConta.length());
	}
	
	@Test
	public void buildPessoaTest() throws Exception {
		
		buildPessoaTestCore(TipoPessoa.PF, pessoaPfScore0And1);
		buildPessoaTestCore(TipoPessoa.PF, pessoaPfScore6And8);
		
		buildPessoaTestCore(TipoPessoa.PJ, pessoaPjScore2And5);
		buildPessoaTestCore(TipoPessoa.PJ, pessoaPjScore9);
		
	    exceptionRule.expect(Exception.class);
	    exceptionRule.expectMessage(PessoaServiceImpl.DOCUMENTO_INVALIDO);
	    
	    @SuppressWarnings("unused")
		Pessoa pessoaDocumentoInvalido = pessoaService.buildPessoa("39570", 9);
	}

	private void buildPessoaTestCore(TipoPessoa tipoPessoaExpected, Pessoa pessoa) {
		assertEquals(tipoPessoaExpected, pessoa.getTipoPessoa());
		assertEquals(tipoPessoaExpected, pessoa.getTipoPessoa());
	}
	
	@Test
	public void buildContaTest() throws Exception {
		
		Conta contaPfScore0And1 = openContaFacade.execute(pessoaPfScore0And1);
		assertNull(contaPfScore0And1.getCartaoCredito());
		assertNull(contaPfScore0And1.getLimiteChequeEspecial());
		

		Conta contaPfScore2And5 = openContaFacade.execute(pessoaPjScore2And5);
		buildContaTestCore(contaPfScore2And5, LIMITE_CHEQUE_ESPECIAL_SCORE_2_AND_5, LIMITE_CARTAO_SCORE_2_AND_5);
		
		Conta contaPfScore6And8 = openContaFacade.execute(pessoaPfScore6And8);
		buildContaTestCore(contaPfScore6And8, LIMITE_CHEQUE_ESPECIAL_SCORE_6_AND_8, LIMITE_CARTAO_SCORE_6_AND_8);
		
		Conta contaPjScore9 = openContaFacade.execute(pessoaPjScore9);
		buildContaTestCore(contaPjScore9, LIMITE_CHEQUE_ESPECIAL_SCORE_9, LIMITE_CARTAO_SCORE_9);
	}

	private void buildContaTestCore(Conta conta, BigDecimal limiteChequeEspecialExpected, BigDecimal limiteCartaoExpected) throws Exception {
		
		assertNotNull(conta);
		assertNotNull(conta.getCartaoCredito());
		
		assertEquals(conta.getLimiteChequeEspecial(), limiteChequeEspecialExpected);
		assertEquals(conta.getCartaoCredito().getLimite(), limiteCartaoExpected);
	}
	

}
