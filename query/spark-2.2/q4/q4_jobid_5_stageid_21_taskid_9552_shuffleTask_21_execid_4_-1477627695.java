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
/* 023 */
/* 024 */   public GeneratedIterator(Object[] references) {
/* 025 */     this.references = references;
/* 026 */   }
/* 027 */
/* 028 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 029 */     partitionIndex = index;
/* 030 */     this.inputs = inputs;
/* 031 */     smj_leftInput = inputs[0];
/* 032 */     smj_rightInput = inputs[1];
/* 033 */
/* 034 */     smj_rightRow = null;
/* 035 */
/* 036 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 037 */
/* 038 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 039 */     smj_result = new UnsafeRow(10);
/* 040 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 256);
/* 041 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 10);
/* 042 */
/* 043 */   }
/* 044 */
/* 045 */   private boolean findNextInnerJoinRows(
/* 046 */     scala.collection.Iterator leftIter,
/* 047 */     scala.collection.Iterator rightIter) {
/* 048 */     smj_leftRow = null;
/* 049 */     int comp = 0;
/* 050 */     while (smj_leftRow == null) {
/* 051 */       if (!leftIter.hasNext()) return false;
/* 052 */       smj_leftRow = (InternalRow) leftIter.next();
/* 053 */
/* 054 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 055 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 056 */       if (smj_isNull) {
/* 057 */         smj_leftRow = null;
/* 058 */         continue;
/* 059 */       }
/* 060 */       if (!smj_matches.isEmpty()) {
/* 061 */         comp = 0;
/* 062 */         if (comp == 0) {
/* 063 */           comp = smj_value.compare(smj_value3);
/* 064 */         }
/* 065 */
/* 066 */         if (comp == 0) {
/* 067 */           return true;
/* 068 */         }
/* 069 */         smj_matches.clear();
/* 070 */       }
/* 071 */
/* 072 */       do {
/* 073 */         if (smj_rightRow == null) {
/* 074 */           if (!rightIter.hasNext()) {
/* 075 */             smj_value3 = smj_value.clone();
/* 076 */             return !smj_matches.isEmpty();
/* 077 */           }
/* 078 */           smj_rightRow = (InternalRow) rightIter.next();
/* 079 */
/* 080 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 081 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 082 */           if (smj_isNull1) {
/* 083 */             smj_rightRow = null;
/* 084 */             continue;
/* 085 */           }
/* 086 */           smj_value2 = smj_value1.clone();
/* 087 */         }
/* 088 */
/* 089 */         comp = 0;
/* 090 */         if (comp == 0) {
/* 091 */           comp = smj_value.compare(smj_value2);
/* 092 */         }
/* 093 */
/* 094 */         if (comp > 0) {
/* 095 */           smj_rightRow = null;
/* 096 */         } else if (comp < 0) {
/* 097 */           if (!smj_matches.isEmpty()) {
/* 098 */             smj_value3 = smj_value.clone();
/* 099 */             return true;
/* 100 */           }
/* 101 */           smj_leftRow = null;
/* 102 */         } else {
/* 103 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 104 */           smj_rightRow = null;;
/* 105 */         }
/* 106 */       } while (smj_leftRow != null);
/* 107 */     }
/* 108 */     return false; // unreachable
/* 109 */   }
/* 110 */
/* 111 */   protected void processNext() throws java.io.IOException {
/* 112 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 113 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 114 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 115 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 116 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 117 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 118 */       while (smj_iterator.hasNext()) {
/* 119 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 120 */
/* 121 */         smj_numOutputRows.add(1);
/* 122 */
/* 123 */         boolean smj_isNull4 = smj_rightRow1.isNullAt(0);
/* 124 */         UTF8String smj_value6 = smj_isNull4 ? null : (smj_rightRow1.getUTF8String(0));
/* 125 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 126 */         UTF8String smj_value7 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 127 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(2);
/* 128 */         UTF8String smj_value8 = smj_isNull6 ? null : (smj_rightRow1.getUTF8String(2));
/* 129 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(3);
/* 130 */         UTF8String smj_value9 = smj_isNull7 ? null : (smj_rightRow1.getUTF8String(3));
/* 131 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(4);
/* 132 */         UTF8String smj_value10 = smj_isNull8 ? null : (smj_rightRow1.getUTF8String(4));
/* 133 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(5);
/* 134 */         UTF8String smj_value11 = smj_isNull9 ? null : (smj_rightRow1.getUTF8String(5));
/* 135 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(6);
/* 136 */         UTF8String smj_value12 = smj_isNull10 ? null : (smj_rightRow1.getUTF8String(6));
/* 137 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(7);
/* 138 */         double smj_value13 = smj_isNull11 ? -1.0 : (smj_rightRow1.getDouble(7));
/* 139 */         smj_holder.reset();
/* 140 */
/* 141 */         smj_rowWriter.zeroOutNullBytes();
/* 142 */
/* 143 */         if (smj_isNull2) {
/* 144 */           smj_rowWriter.setNullAt(0);
/* 145 */         } else {
/* 146 */           smj_rowWriter.write(0, smj_value4);
/* 147 */         }
/* 148 */
/* 149 */         if (smj_isNull3) {
/* 150 */           smj_rowWriter.setNullAt(1);
/* 151 */         } else {
/* 152 */           smj_rowWriter.write(1, smj_value5);
/* 153 */         }
/* 154 */
/* 155 */         if (smj_isNull4) {
/* 156 */           smj_rowWriter.setNullAt(2);
/* 157 */         } else {
/* 158 */           smj_rowWriter.write(2, smj_value6);
/* 159 */         }
/* 160 */
/* 161 */         if (smj_isNull5) {
/* 162 */           smj_rowWriter.setNullAt(3);
/* 163 */         } else {
/* 164 */           smj_rowWriter.write(3, smj_value7);
/* 165 */         }
/* 166 */
/* 167 */         if (smj_isNull6) {
/* 168 */           smj_rowWriter.setNullAt(4);
/* 169 */         } else {
/* 170 */           smj_rowWriter.write(4, smj_value8);
/* 171 */         }
/* 172 */
/* 173 */         if (smj_isNull7) {
/* 174 */           smj_rowWriter.setNullAt(5);
/* 175 */         } else {
/* 176 */           smj_rowWriter.write(5, smj_value9);
/* 177 */         }
/* 178 */
/* 179 */         if (smj_isNull8) {
/* 180 */           smj_rowWriter.setNullAt(6);
/* 181 */         } else {
/* 182 */           smj_rowWriter.write(6, smj_value10);
/* 183 */         }
/* 184 */
/* 185 */         if (smj_isNull9) {
/* 186 */           smj_rowWriter.setNullAt(7);
/* 187 */         } else {
/* 188 */           smj_rowWriter.write(7, smj_value11);
/* 189 */         }
/* 190 */
/* 191 */         if (smj_isNull10) {
/* 192 */           smj_rowWriter.setNullAt(8);
/* 193 */         } else {
/* 194 */           smj_rowWriter.write(8, smj_value12);
/* 195 */         }
/* 196 */
/* 197 */         if (smj_isNull11) {
/* 198 */           smj_rowWriter.setNullAt(9);
/* 199 */         } else {
/* 200 */           smj_rowWriter.write(9, smj_value13);
/* 201 */         }
/* 202 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 203 */         append(smj_result.copy());
/* 204 */
/* 205 */       }
/* 206 */       if (shouldStop()) return;
/* 207 */     }
/* 208 */   }
/* 209 */ }
