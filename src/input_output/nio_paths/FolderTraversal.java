package input_output.nio_paths;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FolderTraversal extends SimpleFileVisitor<Path> {
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println( "Dir:  " + dir.toAbsolutePath() );
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println( "File: " + file.toAbsolutePath() );
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.println( "Falha ao acessar o ficheiro \'" +file.toAbsolutePath()+ "\'" + exc.getMessage() );
		return super.visitFileFailed(file, exc);
	}
}
