/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeRowJoiner();
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeRowJoiner extends org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner {
/* 006 */   private byte[] buf = new byte[64];
/* 007 */   private UnsafeRow out = new UnsafeRow(2);
/* 008 */
/* 009 */   public UnsafeRow join(UnsafeRow row1, UnsafeRow row2) {
/* 010 */     // row1: 1 fields, 1 words in bitset
/* 011 */     // row2: 1, 1 words in bitset
/* 012 */     // output: 2 fields, 1 words in bitset
/* 013 */     final int sizeInBytes = row1.getSizeInBytes() + row2.getSizeInBytes() - 8;
/* 014 */     if (sizeInBytes > buf.length) {
/* 015 */       buf = new byte[sizeInBytes];
/* 016 */     }
/* 017 */
/* 018 */     final java.lang.Object obj1 = row1.getBaseObject();
/* 019 */     final long offset1 = row1.getBaseOffset();
/* 020 */     final java.lang.Object obj2 = row2.getBaseObject();
/* 021 */     final long offset2 = row2.getBaseOffset();
/* 022 */
/* 023 */     Platform.putLong(buf, 16, Platform.getLong(obj1, offset1 + 0) | (Platform.getLong(obj2, offset2) << 1));
/* 024 */
/* 025 */     // Copy fixed length data for row1
/* 026 */     Platform.copyMemory(
/* 027 */       obj1, offset1 + 8,
/* 028 */       buf, 24,
/* 029 */       8);
/* 030 */
/* 031 */
/* 032 */     // Copy fixed length data for row2
/* 033 */     Platform.copyMemory(
/* 034 */       obj2, offset2 + 8,
/* 035 */       buf, 32,
/* 036 */       8);
/* 037 */
/* 038 */
/* 039 */     // Copy variable length data for row1
/* 040 */     long numBytesVariableRow1 = row1.getSizeInBytes() - 16;
/* 041 */     Platform.copyMemory(
/* 042 */       obj1, offset1 + 16,
/* 043 */       buf, 40,
/* 044 */       numBytesVariableRow1);
/* 045 */
/* 046 */
/* 047 */     // Copy variable length data for row2
/* 048 */     long numBytesVariableRow2 = row2.getSizeInBytes() - 16;
/* 049 */     Platform.copyMemory(
/* 050 */       obj2, offset2 + 16,
/* 051 */       buf, 40 + numBytesVariableRow1,
/* 052 */       numBytesVariableRow2);
/* 053 */
/* 054 */
/* 055 */
/* 056 */
/* 057 */     out.pointTo(buf, sizeInBytes);
/* 058 */
/* 059 */     return out;
/* 060 */   }
/* 061 */ }
