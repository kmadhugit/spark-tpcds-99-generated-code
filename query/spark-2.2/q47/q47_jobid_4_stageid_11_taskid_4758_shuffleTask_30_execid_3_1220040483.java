/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */
/* 014 */   public GeneratedIterator(Object[] references) {
/* 015 */     this.references = references;
/* 016 */   }
/* 017 */
/* 018 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 019 */     partitionIndex = index;
/* 020 */     this.inputs = inputs;
/* 021 */     inputadapter_input = inputs[0];
/* 022 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 023 */     filter_result = new UnsafeRow(9);
/* 024 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 128);
/* 025 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 026 */
/* 027 */   }
/* 028 */
/* 029 */   protected void processNext() throws java.io.IOException {
/* 030 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 031 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 032 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 033 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 034 */
/* 035 */       if (!(!(inputadapter_isNull4))) continue;
/* 036 */
/* 037 */       boolean filter_isNull2 = false;
/* 038 */
/* 039 */       boolean filter_value2 = false;
/* 040 */       filter_value2 = inputadapter_value4 == 1999;
/* 041 */       if (!filter_value2) continue;
/* 042 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 043 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 044 */
/* 045 */       if (!(!(inputadapter_isNull7))) continue;
/* 046 */
/* 047 */       boolean filter_isNull7 = false;
/* 048 */
/* 049 */       boolean filter_value7 = false;
/* 050 */       filter_value7 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value7, 0.0D) > 0;
/* 051 */       if (!filter_value7) continue;
/* 052 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 053 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 054 */
/* 055 */       boolean filter_isNull10 = true;
/* 056 */       boolean filter_value10 = false;
/* 057 */
/* 058 */       boolean filter_isNull11 = true;
/* 059 */       double filter_value11 = -1.0;
/* 060 */
/* 061 */       boolean filter_isNull12 = false;
/* 062 */
/* 063 */       boolean filter_value12 = false;
/* 064 */       filter_value12 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value7, 0.0D) > 0;
/* 065 */       if (!false && filter_value12) {
/* 066 */         boolean filter_isNull15 = false;
/* 067 */         double filter_value15 = -1.0;
/* 068 */         if (inputadapter_isNull7 || inputadapter_value7 == 0) {
/* 069 */           filter_isNull15 = true;
/* 070 */         } else {
/* 071 */           boolean filter_isNull17 = true;
/* 072 */           double filter_value17 = -1.0;
/* 073 */
/* 074 */           if (!inputadapter_isNull6) {
/* 075 */             filter_isNull17 = false; // resultCode could change nullability.
/* 076 */             filter_value17 = inputadapter_value6 - inputadapter_value7;
/* 077 */
/* 078 */           }
/* 079 */           boolean filter_isNull16 = filter_isNull17;
/* 080 */           double filter_value16 = -1.0;
/* 081 */
/* 082 */           if (!filter_isNull17) {
/* 083 */             filter_value16 = (double)(java.lang.Math.abs(filter_value17));
/* 084 */           }
/* 085 */           if (filter_isNull16) {
/* 086 */             filter_isNull15 = true;
/* 087 */           } else {
/* 088 */             filter_value15 = (double)(filter_value16 / inputadapter_value7);
/* 089 */           }
/* 090 */         }
/* 091 */         filter_isNull11 = filter_isNull15;
/* 092 */         filter_value11 = filter_value15;
/* 093 */       }
/* 094 */
/* 095 */       else {
/* 096 */         final double filter_value21 = -1.0;
/* 097 */         filter_isNull11 = true;
/* 098 */         filter_value11 = filter_value21;
/* 099 */       }
/* 100 */       if (!filter_isNull11) {
/* 101 */         filter_isNull10 = false; // resultCode could change nullability.
/* 102 */         filter_value10 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value11, 0.1D) > 0;
/* 103 */
/* 104 */       }
/* 105 */       if (filter_isNull10 || !filter_value10) continue;
/* 106 */
/* 107 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 108 */       int inputadapter_value8 = inputadapter_isNull8 ? -1 : (inputadapter_row.getInt(8));
/* 109 */
/* 110 */       if (!(!(inputadapter_isNull8))) continue;
/* 111 */
/* 112 */       filter_numOutputRows.add(1);
/* 113 */
/* 114 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 115 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 116 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 117 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 118 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 119 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 120 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 121 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 122 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 123 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 124 */       filter_holder.reset();
/* 125 */
/* 126 */       filter_rowWriter.zeroOutNullBytes();
/* 127 */
/* 128 */       if (inputadapter_isNull) {
/* 129 */         filter_rowWriter.setNullAt(0);
/* 130 */       } else {
/* 131 */         filter_rowWriter.write(0, inputadapter_value);
/* 132 */       }
/* 133 */
/* 134 */       if (inputadapter_isNull1) {
/* 135 */         filter_rowWriter.setNullAt(1);
/* 136 */       } else {
/* 137 */         filter_rowWriter.write(1, inputadapter_value1);
/* 138 */       }
/* 139 */
/* 140 */       if (inputadapter_isNull2) {
/* 141 */         filter_rowWriter.setNullAt(2);
/* 142 */       } else {
/* 143 */         filter_rowWriter.write(2, inputadapter_value2);
/* 144 */       }
/* 145 */
/* 146 */       if (inputadapter_isNull3) {
/* 147 */         filter_rowWriter.setNullAt(3);
/* 148 */       } else {
/* 149 */         filter_rowWriter.write(3, inputadapter_value3);
/* 150 */       }
/* 151 */
/* 152 */       filter_rowWriter.write(4, inputadapter_value4);
/* 153 */
/* 154 */       if (inputadapter_isNull5) {
/* 155 */         filter_rowWriter.setNullAt(5);
/* 156 */       } else {
/* 157 */         filter_rowWriter.write(5, inputadapter_value5);
/* 158 */       }
/* 159 */
/* 160 */       if (inputadapter_isNull6) {
/* 161 */         filter_rowWriter.setNullAt(6);
/* 162 */       } else {
/* 163 */         filter_rowWriter.write(6, inputadapter_value6);
/* 164 */       }
/* 165 */
/* 166 */       filter_rowWriter.write(7, inputadapter_value7);
/* 167 */
/* 168 */       filter_rowWriter.write(8, inputadapter_value8);
/* 169 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 170 */       append(filter_result);
/* 171 */       if (shouldStop()) return;
/* 172 */     }
/* 173 */   }
/* 174 */ }
