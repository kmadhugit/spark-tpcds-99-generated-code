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
/* 019 */   private UTF8String smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private double smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 024 */   private UnsafeRow smj_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 027 */   private UnsafeRow project_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 030 */
/* 031 */   public GeneratedIterator(Object[] references) {
/* 032 */     this.references = references;
/* 033 */   }
/* 034 */
/* 035 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 036 */     partitionIndex = index;
/* 037 */     this.inputs = inputs;
/* 038 */     smj_leftInput = inputs[0];
/* 039 */     smj_rightInput = inputs[1];
/* 040 */
/* 041 */     smj_rightRow = null;
/* 042 */
/* 043 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 044 */
/* 045 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 046 */     smj_result = new UnsafeRow(6);
/* 047 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 048 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 6);
/* 049 */     project_result = new UnsafeRow(5);
/* 050 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 051 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   private boolean findNextInnerJoinRows(
/* 056 */     scala.collection.Iterator leftIter,
/* 057 */     scala.collection.Iterator rightIter) {
/* 058 */     smj_leftRow = null;
/* 059 */     int comp = 0;
/* 060 */     while (smj_leftRow == null) {
/* 061 */       if (!leftIter.hasNext()) return false;
/* 062 */       smj_leftRow = (InternalRow) leftIter.next();
/* 063 */
/* 064 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 065 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 066 */       if (smj_isNull) {
/* 067 */         smj_leftRow = null;
/* 068 */         continue;
/* 069 */       }
/* 070 */       if (!smj_matches.isEmpty()) {
/* 071 */         comp = 0;
/* 072 */         if (comp == 0) {
/* 073 */           comp = smj_value.compare(smj_value3);
/* 074 */         }
/* 075 */
/* 076 */         if (comp == 0) {
/* 077 */           return true;
/* 078 */         }
/* 079 */         smj_matches.clear();
/* 080 */       }
/* 081 */
/* 082 */       do {
/* 083 */         if (smj_rightRow == null) {
/* 084 */           if (!rightIter.hasNext()) {
/* 085 */             smj_value3 = smj_value.clone();
/* 086 */             return !smj_matches.isEmpty();
/* 087 */           }
/* 088 */           smj_rightRow = (InternalRow) rightIter.next();
/* 089 */
/* 090 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 091 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 092 */           if (smj_isNull1) {
/* 093 */             smj_rightRow = null;
/* 094 */             continue;
/* 095 */           }
/* 096 */           smj_value2 = smj_value1.clone();
/* 097 */         }
/* 098 */
/* 099 */         comp = 0;
/* 100 */         if (comp == 0) {
/* 101 */           comp = smj_value.compare(smj_value2);
/* 102 */         }
/* 103 */
/* 104 */         if (comp > 0) {
/* 105 */           smj_rightRow = null;
/* 106 */         } else if (comp < 0) {
/* 107 */           if (!smj_matches.isEmpty()) {
/* 108 */             smj_value3 = smj_value.clone();
/* 109 */             return true;
/* 110 */           }
/* 111 */           smj_leftRow = null;
/* 112 */         } else {
/* 113 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 114 */           smj_rightRow = null;;
/* 115 */         }
/* 116 */       } while (smj_leftRow != null);
/* 117 */     }
/* 118 */     return false; // unreachable
/* 119 */   }
/* 120 */
/* 121 */   protected void processNext() throws java.io.IOException {
/* 122 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 123 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 124 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 125 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 126 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 127 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 128 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 129 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 130 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 131 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 132 */       while (smj_iterator.hasNext()) {
/* 133 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 134 */
/* 135 */         smj_numOutputRows.add(1);
/* 136 */
/* 137 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(1);
/* 138 */         double smj_value9 = smj_isNull7 ? -1.0 : (smj_rightRow1.getDouble(1));
/* 139 */         project_holder.reset();
/* 140 */
/* 141 */         project_rowWriter.zeroOutNullBytes();
/* 142 */
/* 143 */         if (smj_isNull2) {
/* 144 */           project_rowWriter.setNullAt(0);
/* 145 */         } else {
/* 146 */           project_rowWriter.write(0, smj_value4);
/* 147 */         }
/* 148 */
/* 149 */         if (smj_isNull3) {
/* 150 */           project_rowWriter.setNullAt(1);
/* 151 */         } else {
/* 152 */           project_rowWriter.write(1, smj_value5);
/* 153 */         }
/* 154 */
/* 155 */         if (smj_isNull4) {
/* 156 */           project_rowWriter.setNullAt(2);
/* 157 */         } else {
/* 158 */           project_rowWriter.write(2, smj_value6);
/* 159 */         }
/* 160 */
/* 161 */         if (smj_isNull5) {
/* 162 */           project_rowWriter.setNullAt(3);
/* 163 */         } else {
/* 164 */           project_rowWriter.write(3, smj_value7);
/* 165 */         }
/* 166 */
/* 167 */         if (smj_isNull7) {
/* 168 */           project_rowWriter.setNullAt(4);
/* 169 */         } else {
/* 170 */           project_rowWriter.write(4, smj_value9);
/* 171 */         }
/* 172 */         project_result.setTotalSize(project_holder.totalSize());
/* 173 */         append(project_result.copy());
/* 174 */
/* 175 */       }
/* 176 */       if (shouldStop()) return;
/* 177 */     }
/* 178 */   }
/* 179 */ }
