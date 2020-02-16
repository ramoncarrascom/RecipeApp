package es.ramoncarrasco.spring5recipeapp.converters;

import es.ramoncarrasco.spring5recipeapp.commands.NoteCommand;
import es.ramoncarrasco.spring5recipeapp.domain.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * NoteCommand -> Note converter tests
 * @author Ramón Carrasco
 * From Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
public class NotesCommandToNotesTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NoteCommandToNote converter;

    @Before
    public void setUp() throws Exception {
        converter = new NoteCommandToNote();

    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NoteCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NoteCommand notesCommand = new NoteCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Note note = converter.convert(notesCommand);

        //then
        assertNotNull(note);
        assertEquals(ID_VALUE, note.getId());
        assertEquals(RECIPE_NOTES, note.getRecipeNotes());
    }

}