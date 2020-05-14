package input_output.nio_paths;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		Path path = FileSystems.getDefault().getPath( "WorkingDirectory.txt" );
		printFile( path );
		Path path1 = FileSystems.getDefault().getPath( "files/SubDirectory.txt" );
		printFile( path1 );
		Path path1_ = FileSystems.getDefault().getPath( "files", "SubDirectory.txt" );
		printFile( path1_ );
		Path path2 = FileSystems.getDefault().getPath( "../EclipseWorkspace.txt" );
		printFile( path2 );
		Path path3 = Paths.get( "/home/bento/eclipse-workspace/EclipseWorkspace.txt" );
		printFile( path3 );
		Path path4 = Paths.get( "." );
		System.out.println( path4.toAbsolutePath() );
		Path path5 = Paths.get(path4.toString(), "WorkingDirectory.txt");
		printFile( path5 );
		Path path6 = Paths.get( "/home", "bento", "eclipse-workspace", "EclipseWorkspace.txt" );
		System.out.println( path6.toAbsolutePath() );
		printFile( path6 );
		Path path7 = Paths.get(path4.toString(), "WorkingDirectory.txt");
		System.out.println( path7.toAbsolutePath() );
		System.out.println( path7.normalize().toAbsolutePath() );
		printFile( path7 );
		
		Path path8 = Paths.get( "ficheiroQueNaoExiste.txt" );
		System.out.println( path8.toAbsolutePath() );
		
		Path path9 = Paths.get( "/bento/teste/data", "abc", "qualquer.txt" );
		if ( Files.exists(path9) ) {
			System.out.println( path9.toAbsolutePath() );
		} else {
			System.out.println( "Path nao existe" );
		}
		
		try {
			//to copy files
			Path destination = Paths.get( path.toAbsolutePath().getParent().toString(), "Copied.txt" );
			Files.copy( path , destination, StandardCopyOption.REPLACE_EXISTING );
			
			//to move or rename files
			Path new_destination = Paths.get( path.toAbsolutePath().getParent().toString(), "MovedOrRenamed.txt" );
			Files.move(destination, new_destination, StandardCopyOption.REPLACE_EXISTING );

			//just copy to delete the file
			Path destination2 = Paths.get( path.toAbsolutePath().getParent().toString(), "Copied.txt" );
			Files.copy( new_destination , destination2 );
			Files.deleteIfExists( destination2 );
			
			Path path10 = FileSystems.getDefault().getPath( "pasta1/psta2/pasta3" );
			if ( !Files.exists( path10 ) ) {
				Files.createDirectories( path10 );//quando quer criar uma hierarquia de pastas
			}
			
			Path path11 = FileSystems.getDefault().getPath( path10.toString(), "pasta4" );
			if ( !Files.exists( path11 ) ) {
				Files.createDirectory( path11 );//Para criar apenas uma pasta
			}
			
			Path path12 = FileSystems.getDefault().getPath( path11.toString(), "criadoEmJava.txt" );
			if ( !Files.exists( path12 ) ) {
				Files.createFile( path12 );
			}
			
			System.out.println( "Tamanho: " + Files.size(path12) );
			System.out.println( "Last Modified: " + Files.getLastModifiedTime( path12) );
			System.out.println( "Owner: " + Files.getOwner(path12) );
			
			BasicFileAttributes attributes = Files.readAttributes( path12, BasicFileAttributes.class );
			
			System.out.println( "Tamanho: " + attributes.size() );
			System.out.println( "Last Modified: " + attributes.lastModifiedTime() );
			System.out.println( "Creation Time: " + attributes.creationTime() );
			System.out.println( "E pasta? " + attributes.isDirectory() );
			System.out.println( "E um ficheiro regural? " + attributes.isRegularFile() );
			System.out.println( "E shortcut? " + attributes.isSymbolicLink() );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		Path path13 = FileSystems.getDefault().getPath( "." );
		//traverseFolder( path13 );
		//conteudoFiltrado( path13, "*.{dat,txt}" );
		//imprimirPastas( path13 );
		
		///home/bento/eclipse-workspace/EclipseWorkspace.txt
		String separadorDoEstatico = File.separator;// ou
		String separador = FileSystems.getDefault().getSeparator();
		Path path14 = FileSystems.getDefault().getPath( "home", separador, "bento", separador,
														"eclipse-workspace", separador, 
														"EclipseWorkspace.txt");
		System.out.println( path14 );
		
		try {
			//cria um ficheiro temporario, na pasta de ficheiros temporarios do sistema operativo
			//e coloca o primeiro String como o prefixo ou inicio do nome do ficheiro e o segundo como o
			//suffixo, normalmente a extensao. O java acrescenta um numero no meio para dar o nome final.
			//ex.: /tmp/bento8801891373711142786.ben
			Path path15 = Files.createTempFile( "bento", ".ben" );
			System.out.println( path15 );
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n******************************\n");
		Iterable<FileStore> filesStores = FileSystems.getDefault().getFileStores();
		for ( FileStore store : filesStores ) {
			System.out.println( "Nome e endereco do filestore: " + store );
			System.out.println( "Nome: " + store.name() );
		}
		System.out.println("\n******************************\n");
		
		Iterable<Path> roodDirectories = FileSystems.getDefault().getRootDirectories();
		for ( Path rootDirectory : roodDirectories ) {
			System.out.println( "Root Directory: " + rootDirectory );
		}
		System.out.println("\n******************************\n");
		*/
		
		Path projecto = FileSystems.getDefault().getPath("src/input_output");
		try {
			Files.walkFileTree( projecto, new FolderTraversal() );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void printFile( Path path ) {
		try ( BufferedReader fileReader = Files.newBufferedReader(path) ) {
			String line;
			while ( (line=fileReader.readLine()) != null ) {
				System.out.println( line );
			}
		} catch( IOException exception ) {
			exception.printStackTrace();
		}
	}
	
	private static int level = 0;
	public static void traverseFolder( Path path ) {
		//lista todo conteudo sem filtros
		try ( DirectoryStream<Path> pasta = Files.newDirectoryStream(path) ){
			for ( Path conteudo : pasta ) {
				if ( Files.isDirectory(conteudo) ) {
					for ( int i=0; i<level; i++ ) {
						System.out.print(" ");
					}
					System.out.println( "+ " +conteudo.getFileName() );
					level++;
					traverseFolder( conteudo );
					level--;
				} else {
					for ( int i=0; i<level; i++ ) {
						System.out.print(" ");
					}
					System.out.println( "- " +conteudo.getFileName() );
				}
			}
			
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
	
	
	public static void conteudoFiltrado( Path path, String filtro ) {
		//para aplicar filtros simples, podemos usar o segundo parametro e escrever la os filtros
		//vai imprimir apenas ficheiros que terminam com extensao .dat ou .txt
		try (DirectoryStream<Path> pasta1 = Files.newDirectoryStream(path, filtro) ){
			System.out.println("\n*************************************************\n");
			System.out.println("Ficheiros .dat e .txt:");
			for ( Path conteudo : pasta1 ) {
				System.out.println( conteudo.getFileName() );
			}
			System.out.println("\n*************************************************\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void imprimirPastas( Path path ) {
		DirectoryStream.Filter<Path> filtro = new Filter<Path>() {
			@Override
			public boolean accept(Path entry) throws IOException {
				return Files.isDirectory( entry );
			}
		};
		
		
		try ( DirectoryStream<Path> pasta = Files.newDirectoryStream( path, filtro ) ){
			System.out.println("\n*************************************************\n");
			for ( Path conteudo : pasta ) {
				System.out.println( conteudo.getFileName() );
			}
			System.out.println("\n*************************************************\n");
			
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}





