package es.ramoncarrasco.spring5recipeapp.converters;

import es.ramoncarrasco.spring5recipeapp.commands.NoteCommand;
import es.ramoncarrasco.spring5recipeapp.domain.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Note -> NoteCommand converter tests
 * @author Ramón Carrasco
 * From Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
public class NotesToNotesCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NoteToNoteCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NoteToNoteCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note note = new Note();
        note.setId(ID_VALUE);
        note.setRecipeNotes(RECIPE_NOTES);

        //when
        NoteCommand noteCommand = converter.convert(note);

        //then
        assertEquals(ID_VALUE, noteCommand.getId());
        assertEquals(RECIPE_NOTES, noteCommand.getRecipeNotes());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }
}