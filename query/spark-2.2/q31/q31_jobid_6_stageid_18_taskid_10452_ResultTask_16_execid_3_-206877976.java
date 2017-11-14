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
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private double smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private double smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 026 */   private UnsafeRow smj_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     smj_leftInput = inputs[0];
/* 038 */     smj_rightInput = inputs[1];
/* 039 */
/* 040 */     smj_rightRow = null;
/* 041 */
/* 042 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 043 */
/* 044 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     smj_result = new UnsafeRow(7);
/* 046 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 047 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
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
/* 122 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 123 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 124 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 125 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 126 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 127 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 128 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 129 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 130 */       while (smj_iterator.hasNext()) {
/* 131 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 132 */
/* 133 */         smj_numOutputRows.add(1);
/* 134 */
/* 135 */         boolean smj_isNull7 = smj_rightRow1.isNullAt(0);
/* 136 */         UTF8String smj_value9 = smj_isNull7 ? null : (smj_rightRow1.getUTF8String(0));
/* 137 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(1);
/* 138 */         double smj_value10 = smj_isNull8 ? -1.0 : (smj_rightRow1.getDouble(1));
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
/* 184 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 185 */         append(smj_result.copy());
/* 186 */
/* 187 */       }
/* 188 */       if (shouldStop()) return;
/* 189 */     }
/* 190 */   }
/* 191 */ }
