package ge.sokolov.voidapp.config;

import ge.sokolov.voidapp.exception.ShellExceptionResolver;
import org.jline.utils.AttributedString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.CommandExceptionResolver;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class ShellConfig implements PromptProvider {

  @Override
  public AttributedString getPrompt() {
    return new AttributedString("void:>");
  }

  @Bean
  public CommandExceptionResolver commandExceptionResolver() {
    return new ShellExceptionResolver();
  }
}
