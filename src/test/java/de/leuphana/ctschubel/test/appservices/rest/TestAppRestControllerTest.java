package de.leuphana.ctschubel.test.appservices.rest;

import de.leuphana.ctschubel.test.model.Song;
import de.leuphana.ctschubel.test.repository.SongSqlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * Test cases for {@link de.leuphana.ctschubel.test.appservices.rest.TestAppRestController}
 * @author ctschubel
 */

@SpringBootTest(classes = {TestAppRestController.class})
@RunWith(SpringRunner.class)
public class TestAppRestControllerTest {

    @Autowired
    private TestAppRestController service;

    @MockBean
    private SongSqlRepository sqlRepository;

    @Test
    public void findSongById_ok() {
        when(sqlRepository.findById(anyInt())).thenReturn(Optional.of(new Song()));
        service.findSongById(12);
        verify(sqlRepository, times(1)).findById(12);
        verifyNoMoreInteractions(sqlRepository);
    }


    @Test
    public void findAll_ok() {
        when(sqlRepository.findAll()).thenReturn(new ArrayList<>());
        service.findAll();
        verify(sqlRepository, times(1)).findAll();
        verifyNoMoreInteractions(sqlRepository);
    }

    @Test
    public void addSong() {
        service.addSong(new Song());
        verify(sqlRepository, times(1)).save(any());
        verifyNoMoreInteractions(sqlRepository);
    }
}
