package es.ramoncarrasco.spring5recipeapp.converters;

import es.ramoncarrasco.spring5recipeapp.commands.NoteCommand;
import es.ramoncarrasco.spring5recipeapp.domain.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * NoteCommand -> Note converter
 * @author Ramón Carrasco
 * From Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Component
public class NoteCommandToNote implements Converter<NoteCommand, Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if(source == null) {
            return null;
        }

        final Note note = new Note();
        note.setId(source.getId());
        note.setRecipeNotes(source.getRecipeNote());
        return note;
    }
}
