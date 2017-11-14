/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(7);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 160);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 7);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull4 = i.isNullAt(4);
/* 029 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 030 */     if (isNull4) {
/* 031 */       rowWriter.setNullAt(4);
/* 032 */     } else {
/* 033 */       rowWriter.write(4, value4);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull5 = i.isNullAt(5);
/* 038 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 039 */     if (isNull5) {
/* 040 */       rowWriter.setNullAt(5);
/* 041 */     } else {
/* 042 */       rowWriter.write(5, value5);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull6 = i.isNullAt(6);
/* 047 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 048 */     if (isNull6) {
/* 049 */       rowWriter.setNullAt(6);
/* 050 */     } else {
/* 051 */       rowWriter.write(6, value6);
/* 052 */     }
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */
/* 057 */   private void apply_0(InternalRow i) {
/* 058 */
/* 059 */
/* 060 */     boolean isNull = i.isNullAt(0);
/* 061 */     UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 062 */     if (isNull) {
/* 063 */       rowWriter.setNullAt(0);
/* 064 */     } else {
/* 065 */       rowWriter.write(0, value);
/* 066 */     }
/* 067 */
/* 068 */
/* 069 */     boolean isNull1 = i.isNullAt(1);
/* 070 */     int value1 = isNull1 ? -1 : (i.getInt(1));
/* 071 */     if (isNull1) {
/* 072 */       rowWriter.setNullAt(1);
/* 073 */     } else {
/* 074 */       rowWriter.write(1, value1);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull2 = i.isNullAt(2);
/* 079 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 080 */     if (isNull2) {
/* 081 */       rowWriter.setNullAt(2);
/* 082 */     } else {
/* 083 */       rowWriter.write(2, value2);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull3 = i.isNullAt(3);
/* 088 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 089 */     if (isNull3) {
/* 090 */       rowWriter.setNullAt(3);
/* 091 */     } else {
/* 092 */       rowWriter.write(3, value3);
/* 093 */     }
/* 094 */
/* 095 */   }
/* 096 */
/* 097 */
/* 098 */   // Scala.Function1 need this
/* 099 */   public java.lang.Object apply(java.lang.Object row) {
/* 100 */     return apply((InternalRow) row);
/* 101 */   }
/* 102 */
/* 103 */   public UnsafeRow apply(InternalRow i) {
/* 104 */     holder.reset();
/* 105 */
/* 106 */     rowWriter.zeroOutNullBytes();
/* 107 */     apply_0(i);
/* 108 */     apply_1(i);
/* 109 */     result.setTotalSize(holder.totalSize());
/* 110 */     return result;
/* 111 */   }
/* 112 */ }
