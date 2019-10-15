package br.fsg.filereader.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

@Embeddable
public class Money implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Money ZERO = new Money(BigDecimal.ZERO);

	@Transient
	private final Locale BRAZIL = new Locale("pt", "BR");

	@Transient
	private final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);

	@Transient
	private final DecimalFormat formatter = new DecimalFormat("¤ ###,###,##0.00", REAL);

	private BigDecimal value;

	public Money() {
		this.value = BigDecimal.ZERO;
	}

	public Money(String valor) {
		if (valor.contains("$")) {
			valor = replaceMaskMoney(valor);
		}
		this.value = new BigDecimal(valor);
	}

	private String replaceMaskMoney(String valor) {
		return valor.replace("R$", StringUtils.EMPTY).replace(".", "").replaceAll("[\\,]\\d{2}$", "").trim();
	}

	public Money(BigDecimal valor) {
		this.value = valor;
	}

	public boolean isValid() {
		throw new NotImplementedException("Não possui implementação");
	}

	public String getFormated() {
		return formatter.format(value);
	}

	public Money plus(Money money) {
		this.value = this.value.add(money.value);
		return this;
	}

	public Money minus(Money money) {
		this.value = this.value.subtract(money.value);
		return this;
	}
}
