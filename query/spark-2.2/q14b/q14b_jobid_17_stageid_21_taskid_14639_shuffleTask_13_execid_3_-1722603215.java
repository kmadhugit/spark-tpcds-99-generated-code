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
/* 014 */     result = new UnsafeRow(3);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 3);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */
/* 026 */   // Scala.Function1 need this
/* 027 */   public java.lang.Object apply(java.lang.Object row) {
/* 028 */     return apply((InternalRow) row);
/* 029 */   }
/* 030 */
/* 031 */   public UnsafeRow apply(InternalRow i) {
/* 032 */     rowWriter.zeroOutNullBytes();
/* 033 */
/* 034 */
/* 035 */     boolean isNull1 = i.isNullAt(0);
/* 036 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 037 */     boolean isNull = isNull1;
/* 038 */     int value = value1;
/* 039 */     if (isNull) {
/* 040 */
/* 041 */       if (!false) {
/* 042 */         isNull = false;
/* 043 */         value = 0;
/* 044 */       }
/* 045 */     }
/* 046 */     if (isNull) {
/* 047 */       rowWriter.setNullAt(0);
/* 048 */     } else {
/* 049 */       rowWriter.write(0, value);
/* 050 */     }
/* 051 */
/* 052 */
/* 053 */     boolean isNull4 = i.isNullAt(1);
/* 054 */     int value4 = isNull4 ? -1 : (i.getInt(1));
/* 055 */     boolean isNull3 = isNull4;
/* 056 */     int value3 = value4;
/* 057 */     if (isNull3) {
/* 058 */
/* 059 */       if (!false) {
/* 060 */         isNull3 = false;
/* 061 */         value3 = 0;
/* 062 */       }
/* 063 */     }
/* 064 */     if (isNull3) {
/* 065 */       rowWriter.setNullAt(1);
/* 066 */     } else {
/* 067 */       rowWriter.write(1, value3);
/* 068 */     }
/* 069 */
/* 070 */
/* 071 */     boolean isNull7 = i.isNullAt(2);
/* 072 */     int value7 = isNull7 ? -1 : (i.getInt(2));
/* 073 */     boolean isNull6 = isNull7;
/* 074 */     int value6 = value7;
/* 075 */     if (isNull6) {
/* 076 */
/* 077 */       if (!false) {
/* 078 */         isNull6 = false;
/* 079 */         value6 = 0;
/* 080 */       }
/* 081 */     }
/* 082 */     if (isNull6) {
/* 083 */       rowWriter.setNullAt(2);
/* 084 */     } else {
/* 085 */       rowWriter.write(2, value6);
/* 086 */     }
/* 087 */     return result;
/* 088 */   }
/* 089 */ }
