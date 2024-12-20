package io.munkush.com;

import io.munkush.com.entity.Product;
import io.munkush.com.entity.Status;
import io.munkush.com.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CamundaDemoApplication {
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CamundaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner lineRunner(){
		return args -> {

			productRepository.save(Product.builder()
					.status(Status.VERIFICATION)
					.name("Trusi")
					.activeId(1L)
					.build());

			productRepository.save(Product.builder()
					.status(Status.DECISION)
					.name("Noski")
					.activeId(1L)
					.build());

			productRepository.save(Product.builder()
					.status(Status.DECISION)
					.name("Monitor")
					.activeId(1L)
					.build());

			productRepository.save(Product.builder()
					.status(Status.UNDER)
					.name("PS")
					.activeId(1L)
					.build());


			System.out.println(productRepository.findByActiveIdAndStatusIn(1L, List.of(Status.VERIFICATION, Status.DECISION)));


		};
	}

}
