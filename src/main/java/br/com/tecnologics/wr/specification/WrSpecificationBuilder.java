package br.com.tecnologics.wr.specification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.data.jpa.domain.Specification;

public class WrSpecificationBuilder<T> {

    public Specification<T> build(String filter) {

        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?);");
        Matcher matcher = pattern.matcher(filter + ";");

        Specification spec = null;

        while (matcher.find()) {
            System.out.println("" + matcher.group(1) + " - " + matcher.group(3));
            if (spec == null) {
                spec = new WrSpecification<T>(matcher.group(1), "", matcher.group(3));
            } else {
                spec = Specification.where(spec).and(new WrSpecification<T>(matcher.group(1), "", matcher.group(3)));
            }

        }

        return spec;

    }
}
