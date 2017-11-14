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
/* 015 */   private UTF8String smj_value5;
/* 016 */   private boolean smj_isNull3;
/* 017 */   private UTF8String smj_value6;
/* 018 */   private boolean smj_isNull4;
/* 019 */   private UTF8String smj_value7;
/* 020 */   private boolean smj_isNull5;
/* 021 */   private int smj_value8;
/* 022 */   private boolean smj_isNull6;
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
/* 046 */     smj_result = new UnsafeRow(5);
/* 047 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 048 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 049 */     project_result = new UnsafeRow(3);
/* 050 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 051 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
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
/* 064 */       boolean smj_isNull1 = smj_leftRow.isNullAt(3);
/* 065 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(3));
/* 066 */       boolean smj_isNull = smj_isNull1;
/* 067 */       long smj_value = -1L;
/* 068 */       if (!smj_isNull1) {
/* 069 */         smj_value = (long) smj_value1;
/* 070 */       }
/* 071 */       if (smj_isNull) {
/* 072 */         smj_leftRow = null;
/* 073 */         continue;
/* 074 */       }
/* 075 */       if (!smj_matches.isEmpty()) {
/* 076 */         comp = 0;
/* 077 */         if (comp == 0) {
/* 078 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 079 */         }
/* 080 */
/* 081 */         if (comp == 0) {
/* 082 */           return true;
/* 083 */         }
/* 084 */         smj_matches.clear();
/* 085 */       }
/* 086 */
/* 087 */       do {
/* 088 */         if (smj_rightRow == null) {
/* 089 */           if (!rightIter.hasNext()) {
/* 090 */             smj_value4 = smj_value;
/* 091 */             return !smj_matches.isEmpty();
/* 092 */           }
/* 093 */           smj_rightRow = (InternalRow) rightIter.next();
/* 094 */
/* 095 */           boolean smj_isNull2 = smj_rightRow.isNullAt(0);
/* 096 */           long smj_value2 = smj_isNull2 ? -1L : (smj_rightRow.getLong(0));
/* 097 */           if (smj_isNull2) {
/* 098 */             smj_rightRow = null;
/* 099 */             continue;
/* 100 */           }
/* 101 */           smj_value3 = smj_value2;
/* 102 */         }
/* 103 */
/* 104 */         comp = 0;
/* 105 */         if (comp == 0) {
/* 106 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 107 */         }
/* 108 */
/* 109 */         if (comp > 0) {
/* 110 */           smj_rightRow = null;
/* 111 */         } else if (comp < 0) {
/* 112 */           if (!smj_matches.isEmpty()) {
/* 113 */             smj_value4 = smj_value;
/* 114 */             return true;
/* 115 */           }
/* 116 */           smj_leftRow = null;
/* 117 */         } else {
/* 118 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 119 */           smj_rightRow = null;;
/* 120 */         }
/* 121 */       } while (smj_leftRow != null);
/* 122 */     }
/* 123 */     return false; // unreachable
/* 124 */   }
/* 125 */
/* 126 */   protected void processNext() throws java.io.IOException {
/* 127 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 128 */       smj_isNull3 = smj_leftRow.isNullAt(0);
/* 129 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(0));
/* 130 */       smj_isNull4 = smj_leftRow.isNullAt(1);
/* 131 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(1));
/* 132 */       smj_isNull5 = smj_leftRow.isNullAt(2);
/* 133 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(2));
/* 134 */       smj_isNull6 = smj_leftRow.isNullAt(3);
/* 135 */       smj_value8 = smj_isNull6 ? -1 : (smj_leftRow.getInt(3));
/* 136 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 137 */       while (smj_iterator.hasNext()) {
/* 138 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 139 */
/* 140 */         smj_numOutputRows.add(1);
/* 141 */
/* 142 */         boolean project_isNull1 = false;
/* 143 */         UTF8String project_value1 = UTF8String.concat(smj_isNull5 ? null : smj_value7, false ? null : ((UTF8String) references[1]), smj_isNull4 ? null : smj_value6);
/* 144 */         if (project_value1 == null) {
/* 145 */           project_isNull1 = true;
/* 146 */         }
/* 147 */         project_holder.reset();
/* 148 */
/* 149 */         project_rowWriter.zeroOutNullBytes();
/* 150 */
/* 151 */         if (smj_isNull3) {
/* 152 */           project_rowWriter.setNullAt(0);
/* 153 */         } else {
/* 154 */           project_rowWriter.write(0, smj_value5);
/* 155 */         }
/* 156 */
/* 157 */         if (project_isNull1) {
/* 158 */           project_rowWriter.setNullAt(1);
/* 159 */         } else {
/* 160 */           project_rowWriter.write(1, project_value1);
/* 161 */         }
/* 162 */
/* 163 */         if (smj_isNull3) {
/* 164 */           project_rowWriter.setNullAt(2);
/* 165 */         } else {
/* 166 */           project_rowWriter.write(2, smj_value5);
/* 167 */         }
/* 168 */         project_result.setTotalSize(project_holder.totalSize());
/* 169 */         append(project_result.copy());
/* 170 */
/* 171 */       }
/* 172 */       if (shouldStop()) return;
/* 173 */     }
/* 174 */   }
/* 175 */ }
