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
/* 012 */   private UTF8String smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private double smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 020 */   private UnsafeRow smj_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */
/* 027 */   public GeneratedIterator(Object[] references) {
/* 028 */     this.references = references;
/* 029 */   }
/* 030 */
/* 031 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 032 */     partitionIndex = index;
/* 033 */     this.inputs = inputs;
/* 034 */     smj_leftInput = inputs[0];
/* 035 */     smj_rightInput = inputs[1];
/* 036 */
/* 037 */     smj_rightRow = null;
/* 038 */
/* 039 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 040 */
/* 041 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 042 */     smj_result = new UnsafeRow(5);
/* 043 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 044 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 045 */     project_result = new UnsafeRow(4);
/* 046 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 047 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private boolean findNextInnerJoinRows(
/* 052 */     scala.collection.Iterator leftIter,
/* 053 */     scala.collection.Iterator rightIter) {
/* 054 */     smj_leftRow = null;
/* 055 */     int comp = 0;
/* 056 */     while (smj_leftRow == null) {
/* 057 */       if (!leftIter.hasNext()) return false;
/* 058 */       smj_leftRow = (InternalRow) leftIter.next();
/* 059 */
/* 060 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 061 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 062 */       if (smj_isNull) {
/* 063 */         smj_leftRow = null;
/* 064 */         continue;
/* 065 */       }
/* 066 */       if (!smj_matches.isEmpty()) {
/* 067 */         comp = 0;
/* 068 */         if (comp == 0) {
/* 069 */           comp = smj_value.compare(smj_value3);
/* 070 */         }
/* 071 */
/* 072 */         if (comp == 0) {
/* 073 */           return true;
/* 074 */         }
/* 075 */         smj_matches.clear();
/* 076 */       }
/* 077 */
/* 078 */       do {
/* 079 */         if (smj_rightRow == null) {
/* 080 */           if (!rightIter.hasNext()) {
/* 081 */             smj_value3 = smj_value.clone();
/* 082 */             return !smj_matches.isEmpty();
/* 083 */           }
/* 084 */           smj_rightRow = (InternalRow) rightIter.next();
/* 085 */
/* 086 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 087 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 088 */           if (smj_isNull1) {
/* 089 */             smj_rightRow = null;
/* 090 */             continue;
/* 091 */           }
/* 092 */           smj_value2 = smj_value1.clone();
/* 093 */         }
/* 094 */
/* 095 */         comp = 0;
/* 096 */         if (comp == 0) {
/* 097 */           comp = smj_value.compare(smj_value2);
/* 098 */         }
/* 099 */
/* 100 */         if (comp > 0) {
/* 101 */           smj_rightRow = null;
/* 102 */         } else if (comp < 0) {
/* 103 */           if (!smj_matches.isEmpty()) {
/* 104 */             smj_value3 = smj_value.clone();
/* 105 */             return true;
/* 106 */           }
/* 107 */           smj_leftRow = null;
/* 108 */         } else {
/* 109 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 110 */           smj_rightRow = null;;
/* 111 */         }
/* 112 */       } while (smj_leftRow != null);
/* 113 */     }
/* 114 */     return false; // unreachable
/* 115 */   }
/* 116 */
/* 117 */   protected void processNext() throws java.io.IOException {
/* 118 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 119 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 120 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 121 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 122 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 123 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 124 */       while (smj_iterator.hasNext()) {
/* 125 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 126 */
/* 127 */         smj_numOutputRows.add(1);
/* 128 */
/* 129 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 130 */         UTF8String smj_value7 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 131 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(2);
/* 132 */         double smj_value8 = smj_isNull6 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 133 */         project_holder.reset();
/* 134 */
/* 135 */         project_rowWriter.zeroOutNullBytes();
/* 136 */
/* 137 */         if (smj_isNull2) {
/* 138 */           project_rowWriter.setNullAt(0);
/* 139 */         } else {
/* 140 */           project_rowWriter.write(0, smj_value4);
/* 141 */         }
/* 142 */
/* 143 */         if (smj_isNull3) {
/* 144 */           project_rowWriter.setNullAt(1);
/* 145 */         } else {
/* 146 */           project_rowWriter.write(1, smj_value5);
/* 147 */         }
/* 148 */
/* 149 */         if (smj_isNull5) {
/* 150 */           project_rowWriter.setNullAt(2);
/* 151 */         } else {
/* 152 */           project_rowWriter.write(2, smj_value7);
/* 153 */         }
/* 154 */
/* 155 */         if (smj_isNull6) {
/* 156 */           project_rowWriter.setNullAt(3);
/* 157 */         } else {
/* 158 */           project_rowWriter.write(3, smj_value8);
/* 159 */         }
/* 160 */         project_result.setTotalSize(project_holder.totalSize());
/* 161 */         append(project_result.copy());
/* 162 */
/* 163 */       }
/* 164 */       if (shouldStop()) return;
/* 165 */     }
/* 166 */   }
/* 167 */ }
