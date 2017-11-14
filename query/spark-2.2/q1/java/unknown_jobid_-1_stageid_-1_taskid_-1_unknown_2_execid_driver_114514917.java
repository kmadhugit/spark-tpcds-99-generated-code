/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private long smj_value3;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private long smj_value4;
/* 015 */   private long smj_value5;
/* 016 */   private boolean smj_isNull3;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 018 */   private UnsafeRow smj_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 021 */   private UnsafeRow project_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 024 */
/* 025 */   public GeneratedIterator(Object[] references) {
/* 026 */     this.references = references;
/* 027 */   }
/* 028 */
/* 029 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 030 */     partitionIndex = index;
/* 031 */     this.inputs = inputs;
/* 032 */     smj_leftInput = inputs[0];
/* 033 */     smj_rightInput = inputs[1];
/* 034 */
/* 035 */     smj_rightRow = null;
/* 036 */
/* 037 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 038 */
/* 039 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 040 */     smj_result = new UnsafeRow(3);
/* 041 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 32);
/* 042 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 3);
/* 043 */     project_result = new UnsafeRow(1);
/* 044 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 045 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private boolean findNextInnerJoinRows(
/* 050 */     scala.collection.Iterator leftIter,
/* 051 */     scala.collection.Iterator rightIter) {
/* 052 */     smj_leftRow = null;
/* 053 */     int comp = 0;
/* 054 */     while (smj_leftRow == null) {
/* 055 */       if (!leftIter.hasNext()) return false;
/* 056 */       smj_leftRow = (InternalRow) leftIter.next();
/* 057 */
/* 058 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 059 */       long smj_value = smj_isNull ? -1L : (smj_leftRow.getLong(0));
/* 060 */       if (smj_isNull) {
/* 061 */         smj_leftRow = null;
/* 062 */         continue;
/* 063 */       }
/* 064 */       if (!smj_matches.isEmpty()) {
/* 065 */         comp = 0;
/* 066 */         if (comp == 0) {
/* 067 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 068 */         }
/* 069 */
/* 070 */         if (comp == 0) {
/* 071 */           return true;
/* 072 */         }
/* 073 */         smj_matches.clear();
/* 074 */       }
/* 075 */
/* 076 */       do {
/* 077 */         if (smj_rightRow == null) {
/* 078 */           if (!rightIter.hasNext()) {
/* 079 */             smj_value4 = smj_value;
/* 080 */             return !smj_matches.isEmpty();
/* 081 */           }
/* 082 */           smj_rightRow = (InternalRow) rightIter.next();
/* 083 */
/* 084 */           boolean smj_isNull2 = smj_rightRow.isNullAt(0);
/* 085 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(0));
/* 086 */           boolean smj_isNull1 = smj_isNull2;
/* 087 */           long smj_value1 = -1L;
/* 088 */           if (!smj_isNull2) {
/* 089 */             smj_value1 = (long) smj_value2;
/* 090 */           }
/* 091 */           if (smj_isNull1) {
/* 092 */             smj_rightRow = null;
/* 093 */             continue;
/* 094 */           }
/* 095 */           smj_value3 = smj_value1;
/* 096 */         }
/* 097 */
/* 098 */         comp = 0;
/* 099 */         if (comp == 0) {
/* 100 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 101 */         }
/* 102 */
/* 103 */         if (comp > 0) {
/* 104 */           smj_rightRow = null;
/* 105 */         } else if (comp < 0) {
/* 106 */           if (!smj_matches.isEmpty()) {
/* 107 */             smj_value4 = smj_value;
/* 108 */             return true;
/* 109 */           }
/* 110 */           smj_leftRow = null;
/* 111 */         } else {
/* 112 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 113 */           smj_rightRow = null;;
/* 114 */         }
/* 115 */       } while (smj_leftRow != null);
/* 116 */     }
/* 117 */     return false; // unreachable
/* 118 */   }
/* 119 */
/* 120 */   protected void processNext() throws java.io.IOException {
/* 121 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 122 */       smj_isNull3 = smj_leftRow.isNullAt(0);
/* 123 */       smj_value5 = smj_isNull3 ? -1L : (smj_leftRow.getLong(0));
/* 124 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 125 */       while (smj_iterator.hasNext()) {
/* 126 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 127 */
/* 128 */         smj_numOutputRows.add(1);
/* 129 */
/* 130 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 131 */         UTF8String smj_value7 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 132 */         project_holder.reset();
/* 133 */
/* 134 */         project_rowWriter.zeroOutNullBytes();
/* 135 */
/* 136 */         if (smj_isNull5) {
/* 137 */           project_rowWriter.setNullAt(0);
/* 138 */         } else {
/* 139 */           project_rowWriter.write(0, smj_value7);
/* 140 */         }
/* 141 */         project_result.setTotalSize(project_holder.totalSize());
/* 142 */         append(project_result.copy());
/* 143 */
/* 144 */       }
/* 145 */       if (shouldStop()) return;
/* 146 */     }
/* 147 */   }
/* 148 */ }
