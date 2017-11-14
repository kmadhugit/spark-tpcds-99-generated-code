/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeRowJoiner();
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeRowJoiner extends org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner {
/* 006 */   private byte[] buf = new byte[64];
/* 007 */   private UnsafeRow out = new UnsafeRow(15);
/* 008 */
/* 009 */   public UnsafeRow join(UnsafeRow row1, UnsafeRow row2) {
/* 010 */     // row1: 10 fields, 1 words in bitset
/* 011 */     // row2: 5, 1 words in bitset
/* 012 */     // output: 15 fields, 1 words in bitset
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
/* 023 */     Platform.putLong(buf, 16, Platform.getLong(obj1, offset1 + 0) | (Platform.getLong(obj2, offset2) << 10));
/* 024 */
/* 025 */     // Copy fixed length data for row1
/* 026 */     Platform.copyMemory(
/* 027 */       obj1, offset1 + 8,
/* 028 */       buf, 24,
/* 029 */       80);
/* 030 */
/* 031 */
/* 032 */     // Copy fixed length data for row2
/* 033 */     Platform.copyMemory(
/* 034 */       obj2, offset2 + 8,
/* 035 */       buf, 104,
/* 036 */       40);
/* 037 */
/* 038 */
/* 039 */     // Copy variable length data for row1
/* 040 */     long numBytesVariableRow1 = row1.getSizeInBytes() - 88;
/* 041 */     Platform.copyMemory(
/* 042 */       obj1, offset1 + 88,
/* 043 */       buf, 144,
/* 044 */       numBytesVariableRow1);
/* 045 */
/* 046 */
/* 047 */     // Copy variable length data for row2
/* 048 */     long numBytesVariableRow2 = row2.getSizeInBytes() - 48;
/* 049 */     Platform.copyMemory(
/* 050 */       obj2, offset2 + 48,
/* 051 */       buf, 144 + numBytesVariableRow1,
/* 052 */       numBytesVariableRow2);
/* 053 */
/* 054 */
/* 055 */     Platform.putLong(buf, 24, Platform.getLong(buf, 24) + (40L << 32));
/* 056 */
/* 057 */
/* 058 */
/* 059 */     Platform.putLong(buf, 40, Platform.getLong(buf, 40) + (40L << 32));
/* 060 */
/* 061 */
/* 062 */     Platform.putLong(buf, 48, Platform.getLong(buf, 48) + (40L << 32));
/* 063 */
/* 064 */
/* 065 */     Platform.putLong(buf, 56, Platform.getLong(buf, 56) + (40L << 32));
/* 066 */
/* 067 */
/* 068 */     Platform.putLong(buf, 64, Platform.getLong(buf, 64) + (40L << 32));
/* 069 */
/* 070 */
/* 071 */     Platform.putLong(buf, 72, Platform.getLong(buf, 72) + (40L << 32));
/* 072 */
/* 073 */
/* 074 */     Platform.putLong(buf, 80, Platform.getLong(buf, 80) + (40L << 32));
/* 075 */
/* 076 */
/* 077 */     Platform.putLong(buf, 88, Platform.getLong(buf, 88) + (40L << 32));
/* 078 */
/* 079 */
/* 080 */     Platform.putLong(buf, 96, Platform.getLong(buf, 96) + (40L << 32));
/* 081 */
/* 082 */
/* 083 */
/* 084 */
/* 085 */
/* 086 */
/* 087 */
/* 088 */     out.pointTo(buf, sizeInBytes);
/* 089 */
/* 090 */     return out;
/* 091 */   }
/* 092 */ }
