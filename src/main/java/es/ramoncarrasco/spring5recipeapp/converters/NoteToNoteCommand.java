package es.ramoncarrasco.spring5recipeapp.converters;

import es.ramoncarrasco.spring5recipeapp.commands.NoteCommand;
import es.ramoncarrasco.spring5recipeapp.domain.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Note -> NoteCommand converter
 * @author Ramón Carrasco
 * From Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Component
public class NoteToNoteCommand implements Converter<Note, NoteCommand>{

    @Synchronized
    @Nullable
    @Override
    public NoteCommand convert(Note source) {
        if (source == null) {
            return null;
        }

        final NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(source.getId());
        noteCommand.setRecipeNotes(source.getRecipeNotes());
        return noteCommand;
    }
}
