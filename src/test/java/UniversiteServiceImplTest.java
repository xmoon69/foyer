import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;
import tn.esprit.tpfoyer.service.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UniversiteServiceImplTest {

    @Mock
    private UniversiteRepository universiteRepository;

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    private Universite universite;

    @BeforeEach
    void setUp() {
        universite = new Universite(); // Remplace cela par un constructeur avec des valeurs si nécessaire
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Université Test");
        universite.setDateCreation(new Date());
    }

    @Test
    void testRetrieveAllUniversites() {
        // Arrange
        List<Universite> universites = new ArrayList<>();
        universites.add(universite);
        when(universiteRepository.findAll()).thenReturn(universites);

        // Act
        List<Universite> result = universiteService.retrieveAllUniversites();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Université Test", result.get(0).getNomUniversite());
        verify(universiteRepository, times(1)).findAll();
    }

    @Test
    void testRetrieveUniversite() {
        // Arrange
        when(universiteRepository.findById(1L)).thenReturn(Optional.of(universite));

        // Act
        Universite result = universiteService.retrieveUniversite(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Université Test", result.getNomUniversite());
        verify(universiteRepository, times(1)).findById(1L);
    }

    @Test
    void testAddUniversite() {
        // Arrange
        when(universiteRepository.save(universite)).thenReturn(universite);

        // Act
        Universite result = universiteService.addUniversite(universite);

        // Assert
        assertNotNull(result);
        assertEquals("Université Test", result.getNomUniversite());
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    void testModifyUniversite() {
        // Arrange
        when(universiteRepository.save(universite)).thenReturn(universite);

        // Act
        Universite result = universiteService.modifyUniversite(universite);

        // Assert
        assertNotNull(result);
        assertEquals("Université Test", result.getNomUniversite());
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    void testRemoveUniversite() {
        // Arrange
        Long idToRemove = 1L;

        // Act
        universiteService.removeUniversite(idToRemove);

        // Assert
        verify(universiteRepository, times(1)).deleteById(idToRemove);
    }
}
